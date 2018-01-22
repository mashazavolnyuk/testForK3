package com.example.masha.testfork3.api.requests;

import com.example.masha.testfork3.data.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRequestListPlaces {
    @GET("posts")
    Call<List<User>> getMainList();
}