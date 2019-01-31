package com.example.avinashravilla.assignments.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.avinashravilla.assignments.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        //Binding Butter knife
        ButterKnife.bind(this);
    }

    /**
     * for assigning layout before binding
     *
     * @return
     */
    @LayoutRes
    public abstract int getContentViewId();

    public void showProgress() {
        if(progress != null) {
            progress.show();
        } else {
            progress = new ProgressDialog(this);
            progress.setMessage(getResources().getString(R.string.loading));
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            progress.show();
        }
    }

    /**
     * removing progress bar
     */
    public void dismissProgress() {
        if(progress != null) {
            progress.dismiss();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
