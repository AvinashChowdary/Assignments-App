package com.example.avinashravilla.assignments.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.avinashravilla.assignments.R;
import com.example.avinashravilla.assignments.activities.AssignmentSubmissionsActivity;
import com.example.avinashravilla.assignments.activities.SubmissionDetailsActivity;
import com.example.avinashravilla.assignments.adapters.viewholders.SubmissionsViewHolder;
import com.example.avinashravilla.assignments.model.submission.Creator;
import com.example.avinashravilla.assignments.model.submission.Submission;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubmissionsAdapter extends AbstractBaseAdapter<Submission, SubmissionsViewHolder> {

    private Context context;

    public SubmissionsAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_submissions;
    }

    @Override
    public SubmissionsViewHolder newViewHolder(View view) {
        return new SubmissionsViewHolder(view);
    }

    @Override
    public void bindView(final SubmissionsViewHolder holder, Submission item) {
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

        holder.getNameTxt().setText(name);
        holder.getSubmittedDateTxt().setText(turnedInDate);
        Glide.with(context).load(student.getAvatars().getLarge()).into(holder.getStudentImg());

    }

}
