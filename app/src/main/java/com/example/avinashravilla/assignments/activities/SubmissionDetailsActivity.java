package com.example.avinashravilla.assignments.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.avinashravilla.assignments.R;
import com.example.avinashravilla.assignments.util.ARToast;

import butterknife.BindView;

public class SubmissionDetailsActivity extends BaseActivity {

    public static final String NAME = "name";
    public static final String TURNED_IN_DATE = "turned_in_date";
    public static final String CONTENT = "content";
    public static final String IMAGE = "image";
    public static final String TITLE = "title";

    @BindView(R.id.img_student)
    ImageView studentImg;

    @BindView(R.id.txt_name)
    TextView studentNameTxt;

    @BindView(R.id.txt_submitted_date)
    TextView submittedDateTxt;

    @BindView(R.id.txt_submission)
    TextView submissionTxt;


    @Override
    public int getContentViewId() {
        return R.layout.activity_submission_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null) {
            getSupportActionBar().setTitle(intent.getStringExtra(TITLE));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            studentNameTxt.setText(intent.getStringExtra(NAME));
            submittedDateTxt.setText(intent.getStringExtra(TURNED_IN_DATE));
            submissionTxt.setText(intent.getStringExtra(CONTENT));
            Glide.with(this).load(intent.getStringExtra(IMAGE)).into(studentImg);

        } else {
            ARToast.showToast(R.string.problem_loading);
            this.finish();
        }
    }

}
