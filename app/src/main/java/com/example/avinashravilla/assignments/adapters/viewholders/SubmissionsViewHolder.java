package com.example.avinashravilla.assignments.adapters.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avinashravilla.assignments.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubmissionsViewHolder extends RecyclerView.ViewHolder {

    private TextView nameTxt;

    private TextView submittedDateTxt;

    private ImageView studentImg;

    private View rootView;


    public SubmissionsViewHolder(@NonNull View itemView) {
        super(itemView);
        rootView = itemView;
        nameTxt = rootView.findViewById(R.id.txt_name);
        submittedDateTxt = rootView.findViewById(R.id.txt_submitted_date);
        studentImg = rootView.findViewById(R.id.img_student);
    }



    public View getRootView() {
        return rootView;
    }

    public ImageView getStudentImg() {
        return studentImg;
    }

    public void setStudentImg(ImageView studentImg) {
        this.studentImg = studentImg;
    }

    public TextView getNameTxt() {
        return nameTxt;
    }

    public void setNameTxt(TextView nameTxt) {
        this.nameTxt = nameTxt;
    }

    public TextView getSubmittedDateTxt() {
        return submittedDateTxt;
    }

    public void setSubmittedDateTxt(TextView submittedDateTxt) {
        this.submittedDateTxt = submittedDateTxt;
    }
}
