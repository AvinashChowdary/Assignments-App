package com.example.avinashravilla.assignments.services.rest;

import com.example.avinashravilla.assignments.services.Services;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class RestClient implements RequestInterceptor {

    public static final int PER_PAGE = 20;
    private final String BASE_URL = "https://api.edmodo.com";

    public static final String ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE1NDg4OTA4ODcsImlzcyI6Imh0dHBzOi8vYXBpLmVkbW9kby5jb20iLCJ1c2VyIjp7ImlkIjo3MzI0MDcyMX0sImFwcCI6eyJpZCI6MTkxfSwiZXhwaXJlc19pbiI6ODY0MDAsInNjb3BlcyI6ImFsbCJ9.zIjBKY3PbVTNDoh09eP1ARe99BrDcVZ6rTetdIzqawCacM8DAiP-o4VnDRHBqj3Ewc9VtKcAfXdgy99sxH0ZjA";

    private Services services;

    public static RestClient getInstance() {
        return new RestClient();
    }

    /**
     * adapter for retrofit
     * @return
     */
    public Services getServices() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(this)
                .setClient(new retrofit.client.UrlConnectionClient())
                .build();
        services = restAdapter.create(Services.class);
        return services;
    }

    @Override
    public void intercept(RequestFacade request) {
        //
    }

}
