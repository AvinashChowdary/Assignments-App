package com.example.avinashravilla.assignments.util;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Toast;

import com.example.avinashravilla.assignments.App;
import com.example.avinashravilla.assignments.R;


public class ARToast {
    private static Toast toast;

    /**
     * Default constructor
     */
    private ARToast() {
        // Private constructor to creating object
    }

    public static Toast showNetworkFailToast() {
        return showToast(R.string.network_not_available);
    }

    public static Toast showToast(int text) {
        return showToast(App.get().getResources().getString(text));
    }

    public static Toast showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(App.get(), text, Toast.LENGTH_LONG);
        } else {
            toast.setText(text);
        }
        if (!AppRunningState.isApplicationBroughtToBackgrounds(App.get())) {
            toast.show();
        }
        return toast;
    }

    @SuppressLint("ShowToast")
    public static boolean isToastShowing() {
        if (toast == null) {
            toast = Toast.makeText(App.get(), App.get().getResources().getString(R.string.app_name),
                    Toast.LENGTH_LONG);
        }
        return toast.getView().getWindowVisibility() == View.VISIBLE ? true : false;
    }

    public static void cancelToast() {
        if (toast == null) {
            toast = Toast.makeText(App.get(), App.get().getResources().getString(R.string.app_name),
                    Toast.LENGTH_LONG);
        }
        toast.cancel();
    }
}
