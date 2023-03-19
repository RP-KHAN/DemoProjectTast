package com.example.demoprojecttast1.apis;

import com.example.demoprojecttast1.models.ApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    @GET("photos")
    Call<List<ApiModel>> getAllJson();

    /*@POST("albums")
    Call<ApiModel> createPost(@Body ApiModel apiModel);*/
}
