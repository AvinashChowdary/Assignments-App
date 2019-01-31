package com.example.avinashravilla.assignments.services;


import com.example.avinashravilla.assignments.model.assignment.Assignment;
import com.example.avinashravilla.assignments.model.submission.Submission;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * interface with list of services
 * implemented in activities
 */
public interface Services {


    @GET("/assignments")
    void getAssignments(@Query("access_token") String accessToken, @Query("page") int page, @Query("per_page") int perPage,
                        Callback<List<Assignment>> assignments);

    @GET("/assignment_submissions")
    void getSubmissions(@Query("assignment_id") String assignmentID, @Query("assignment_creator_id") String assignmentCreatorID,
                        @Query("access_token") String accessToken, @Query("page") int page, @Query("per_page") int perPage,
                        Callback<List<Submission>> assignments);

}
