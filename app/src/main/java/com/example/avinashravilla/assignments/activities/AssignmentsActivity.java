package com.example.avinashravilla.assignments.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.avinashravilla.assignments.R;
import com.example.avinashravilla.assignments.adapters.AbstractBaseAdapter;
import com.example.avinashravilla.assignments.adapters.AssignmentsAdapter;
import com.example.avinashravilla.assignments.model.assignment.Assignment;
import com.example.avinashravilla.assignments.model.assignment.Creator;
import com.example.avinashravilla.assignments.services.Services;
import com.example.avinashravilla.assignments.services.rest.RestClient;
import com.example.avinashravilla.assignments.util.ARToast;
import com.example.avinashravilla.assignments.util.NetworkUtil;
import com.example.avinashravilla.assignments.util.Preferences;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AssignmentsActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, AbsListView.OnScrollListener {

    public static final String ASSIGNMENT = "assignment";
    private static final String DATE_PICKER_DIALOG = "date_picker";
    private int page = 1;

    private AbstractBaseAdapter adapter;

    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.list_assignments)
    ListView assignmentsLst;

    @OnClick(R.id.btn_add_assignment)
    public void addAssignment() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().from(AssignmentsActivity.this).inflate(R.layout.new_assignment, null);
        builder.setView(view);
        view.findViewById(R.id.date_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(view);
            }
        });

        builder.setMessage(getResources().getString(R.string.create_assignment));
        final Dialog dialog = builder.create();
        dialog.setCancelable(true);
        view.findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveLocallyAndRefreshList(view, dialog);
            }
        });
        dialog.show();
    }

    private void saveLocallyAndRefreshList(View view, Dialog dialog) {
        String title = ((EditText) view.findViewById(R.id.edt_title)).getText().toString();
        String desc = ((EditText) view.findViewById(R.id.edt_desc)).getText().toString();
        String[] vals = ((TextView) view.findViewById(R.id.txt_due_date)).getText().toString().split("/");
        String date = vals[2] + "-" +  vals[0] + "-" + vals[1] + "T" + "23:59:00.000Z";
        if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(desc) && !TextUtils.isEmpty(date)) {
            Assignment localAssignment = new Assignment();
            localAssignment.setTitle(title);
            localAssignment.setDescription(desc);
            localAssignment.setDue_at(date);
            localAssignment.setId(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
            Creator creator = new Creator();
            creator.setId(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
            localAssignment.setCreator(creator);


            Preferences pref = Preferences.getIns();
            pref.saveAssignment(localAssignment);
            List<Assignment> assignments = pref.getAssignments();

            ARToast.showToast(R.string.saved_assignment_locally);

            if(adapter != null && assignments.size() > 0) {
                adapter.addAllItems(assignments);
            }
            dialog.dismiss();
        }
    }

    private void setDate(final View rootView) {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        ((TextView) rootView.findViewById(R.id.txt_due_date))
                                .setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                    }
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setVersion(DatePickerDialog.Version.VERSION_2);
        dpd.setAccentColor(getResources().getColor((R.color.colorPrimary)));
        dpd.show(getFragmentManager(), DATE_PICKER_DIALOG);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSwipeRefreshLayout.setNestedScrollingEnabled(true);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        getAssignments(page);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_assignment;
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
        getAssignments(1);
    }

    private void getAssignments(int page) {
        if (NetworkUtil.isOnline(this)) {
            showProgress();
            // getting adapter for retrofit
            Services services = RestClient.getInstance().getServices();
            // calling api with params
            services.getAssignments(RestClient.ACCESS_TOKEN, page, RestClient.PER_PAGE, new Callback<List<Assignment>>() {
                @Override
                public void success(List<Assignment> assignments, Response response) {
                    if (assignments != null && assignments.size() > 0) {
                        setAssignmentsToList(assignments);
                    } else {
                        ARToast.showToast(R.string.no_assignments_found);
                    }
                    dismissProgress();
                }

                @Override
                public void failure(RetrofitError error) {
                    ARToast.showToast(R.string.failed_to_get_assignments);
                    dismissProgress();
                }

            });

        } else {
            ARToast.showNetworkFailToast();
        }
    }

    private void setAssignmentsToList(final List<Assignment> assignments) {
        List<Assignment> locals = Preferences.getIns().getAssignments();
        if (locals != null && locals.size() > 0) {
            assignments.addAll(locals);
        }
        if (adapter != null) {
            if (page == 1) {
                // first page, make list as response
                adapter.addItems(assignments);
            } else {
                // already list has items
                // add newly fetched items to adapter
                adapter.addAllItems(assignments);
            }

        } else {
            // initial load
            adapter = new AssignmentsAdapter(AssignmentsActivity.this);
            adapter.addItems(assignments);
            assignmentsLst.setAdapter(adapter);
            assignmentsLst.setOnScrollListener(this);
        }
        assignmentsLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AssignmentsActivity.this, AssignmentSubmissionsActivity.class);
                Assignment item = assignments.get(position);
                intent.putExtra(AssignmentSubmissionsActivity.TITLE, item.getTitle());
                intent.putExtra(AssignmentSubmissionsActivity.DESCRIPTION, item.getDescription());
                intent.putExtra(AssignmentSubmissionsActivity.ASSIGNMENT_ID, item.getId());
                intent.putExtra(AssignmentSubmissionsActivity.CREATOR_ID, item.getCreator().getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        boolean loadMore = firstVisibleItem + visibleItemCount >= totalItemCount;

        if (loadMore && totalItemCount > RestClient.PER_PAGE && adapter != null) {
            page++;
            getAssignments(page);
        }
    }
}
