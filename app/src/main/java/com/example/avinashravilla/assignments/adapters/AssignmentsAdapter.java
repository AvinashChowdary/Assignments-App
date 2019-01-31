package com.example.avinashravilla.assignments.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.avinashravilla.assignments.R;
import com.example.avinashravilla.assignments.activities.AssignmentSubmissionsActivity;
import com.example.avinashravilla.assignments.adapters.viewholders.AssignmentsViewHolder;
import com.example.avinashravilla.assignments.model.assignment.Assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AssignmentsAdapter extends AbstractBaseAdapter<Assignment, AssignmentsViewHolder> {

    private Context context;

    public AssignmentsAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_assignments;
    }

    @Override
    public AssignmentsViewHolder newViewHolder(View view) {
        return new AssignmentsViewHolder(view);
    }

    @Override
    public void bindView(AssignmentsViewHolder holder, Assignment item) {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        SimpleDateFormat sdfT = new SimpleDateFormat("MMM dd, yyyy");
        Date date;
        String dueDate = "";
        try {
            date = sdfDate.parse(item.getDue_at());
            dueDate = "due " + sdfT.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.getDueDate().setText(dueDate);
        holder.getTitle().setText(item.getTitle());
    }
}
