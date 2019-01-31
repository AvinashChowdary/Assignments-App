package com.example.avinashravilla.assignments.model.assignment;

public class Recipients {
    private Groups[] groups;

    public Groups[] getGroups() {
        return groups;
    }

    public void setGroups(Groups[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "ClassPojo [groups = " + groups + "]";
    }
}