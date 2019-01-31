package com.example.avinashravilla.assignments.model.submission;

public class Avatars
{
    private String small;

    private String large;

    public String getSmall ()
    {
        return small;
    }

    public void setSmall (String small)
    {
        this.small = small;
    }

    public String getLarge ()
    {
        return large;
    }

    public void setLarge (String large)
    {
        this.large = large;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [small = "+small+", large = "+large+"]";
    }
}