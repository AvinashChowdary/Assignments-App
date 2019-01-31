package com.example.avinashravilla.assignments.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.avinashravilla.assignments.R;
import com.example.avinashravilla.assignments.adapters.AbstractBaseAdapter;
import com.example.avinashravilla.assignments.adapters.SubmissionsAdapter;
import com.example.avinashravilla.assignments.model.submission.Creator;
import com.example.avinashravilla.assignments.model.submission.Submission;
import com.example.avinashravilla.assignments.services.Services;
import com.example.avinashravilla.assignments.services.rest.RestClient;
import com.example.avinashravilla.assignments.util.ARToast;
import com.example.avinashravilla.assignments.util.NetworkUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AssignmentSubmissionsActivity extends BaseActivity implements AbsListView.OnScrollListener {

    public static final String DESCRIPTION = "description";
    public static final String TITLE = "title";
    public static final String CREATOR_ID = "creator_id";
    public static final String ASSIGNMENT_ID = "assignment_id";
    private AbstractBaseAdapter adapter;
    private int page = 1;
    private String assignmentID = "";
    private String creatorID = "";

    @BindView(R.id.list_students)
    ListView studentsLst;

    @BindView(R.id.txt_description)
    TextView descriptionTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent != null) {
            getSupportActionBar().setTitle(intent.getStringExtra(TITLE));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            descriptionTxt.setText(intent.getStringExtra(DESCRIPTION));
            this.assignmentID = intent.getStringExtra(ASSIGNMENT_ID);
            this.creatorID = intent.getStringExtra(CREATOR_ID);
            if(!TextUtils.isEmpty(assignmentID) && !TextUtils.isEmpty(creatorID)) {
                loadSubmissions(page);
            } else {
                ARToast.showToast(R.string.no_assignment_details);
                this.finish();
            }

        } else {
            ARToast.showToast(R.string.problem_loading);
            this.finish();
        }


    }

    private void loadSubmissions(int page) {
        if (NetworkUtil.isOnline(this)) {
            showProgress();
            // getting adapter for retrofit
            Services services = RestClient.getInstance().getServices();
            // calling api with params
            services.getSubmissions(assignmentID, creatorID, RestClient.ACCESS_TOKEN, page, RestClient.PER_PAGE, new Callback<List<Submission>>() {
                @Override
                public void success(List<Submission> submissions, Response response) {
                    if (submissions != null && submissions.size() > 0) {
                        setSubmissionsToList(submissions);
                    } else {
                        ARToast.showToast(R.string.no_submissions_found);
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

    private void setSubmissionsToList(final List<Submission> submissions) {
        if (adapter != null) {
            if (page == 1) {
                // first page, make list as response
                adapter.addItems(submissions);
            } else {
                // already list has items
                // add newly fetched items to adapter
                adapter.addAllItems(submissions);
            }

        } else {
            // initial load
            adapter = new SubmissionsAdapter(AssignmentSubmissionsActivity.this);
            adapter.addItems(submissions);
            studentsLst.setAdapter(adapter);
            studentsLst.setOnScrollListener(this);
        }
        studentsLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Submission item = submissions.get(position);
                Creator student = item.getCreator();
                String name = student.getFirst_name() + " " + student.getLast_name();

                SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
                SimpleDateFormat sdfT = new SimpleDateFormat("MMM dd, yyyy");
                Date date;
                String turnedInDate = "";
                try {
                    date = sdfDate.parse(item.getSubmitted_at());
                    turnedInDate = "turned in " + sdfT.format(date);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(AssignmentSubmissionsActivity.this, SubmissionDetailsActivity.class);
                intent.putExtra(SubmissionDetailsActivity.TITLE, getSupportActionBar().getTitle());
                intent.putExtra(SubmissionDetailsActivity.NAME, name);
                intent.putExtra(SubmissionDetailsActivity.TURNED_IN_DATE, turnedInDate);
                intent.putExtra(SubmissionDetailsActivity.CONTENT, item.getContent());
                intent.putExtra(SubmissionDetailsActivity.IMAGE, student.getAvatars().getLarge());

                // animation for loading to and from image
                String transitionName = getResources().getString(R.string.transition_string);
                ActivityOptionsCompat options =

                        ActivityOptionsCompat.makeSceneTransitionAnimation(AssignmentSubmissionsActivity.this,
                                view,
                                transitionName
                        );

                ActivityCompat.startActivity(AssignmentSubmissionsActivity.this, intent, options.toBundle());
            }
        });
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_assignment_submissions;
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
            loadSubmissions(page);
        }
    }

}
