package com.example.avinashravilla.assignments.adapters.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.avinashravilla.assignments.R;

public class AssignmentsViewHolder extends RecyclerView.ViewHolder{

    private TextView title;

    private TextView dueDate;

    private View rootView;


    public AssignmentsViewHolder(@NonNull View itemView) {
        super(itemView);
        rootView = itemView;
        title = rootView.findViewById(R.id.txt_title);
        dueDate = rootView.findViewById(R.id.txt_due_date);
    }

    public TextView getDueDate() {
        return dueDate;
    }

    public void setDueDate(TextView dueDate) {
        this.dueDate = dueDate;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public View getRootView() {
        return rootView;
    }
}
