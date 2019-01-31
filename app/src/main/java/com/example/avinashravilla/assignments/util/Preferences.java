package com.example.avinashravilla.assignments.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.example.avinashravilla.assignments.App;
import com.example.avinashravilla.assignments.activities.AssignmentsActivity;
import com.example.avinashravilla.assignments.model.assignment.Assignment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class Preferences {
    private static Preferences pref;
    private static SharedPreferences prefObj;
    private static Editor prefsEditor;

    public static Preferences getIns() {
        if (pref == null) {
            pref = new Preferences();
            prefObj = PreferenceManager.getDefaultSharedPreferences(App
                    .get());
            prefsEditor = prefObj.edit();
        }
        return pref;
    }

    public SharedPreferences getSharedPref() {
        if (prefObj == null) {
            prefObj = PreferenceManager.getDefaultSharedPreferences(App
                    .get());
        }
        return prefObj;
    }

    public Editor getEditor() {
        if (prefsEditor == null) {
            prefsEditor = getSharedPref().edit();
        }
        return prefsEditor;
    }

    public void saveAssignment(Assignment localAssignment) {
        String json = getSharedPref().getString(AssignmentsActivity.ASSIGNMENT, "");
        List<Assignment> locals = new Gson().fromJson(json, new TypeToken<List<Assignment>>(){}.getType());
        if(locals == null) {
            locals = new ArrayList<>();
        }
        locals.add(localAssignment);
        String assignment = new Gson().toJson(locals);
        getEditor().putString(AssignmentsActivity.ASSIGNMENT, assignment).commit();
    }

    public List<Assignment> getAssignments() {
        String json = getSharedPref().getString(AssignmentsActivity.ASSIGNMENT, "");
        if(!TextUtils.isEmpty(json)) {
            return new Gson().fromJson(json, new TypeToken<List<Assignment>>() {
            }.getType());
        } else {
            return null;
        }
    }
}
