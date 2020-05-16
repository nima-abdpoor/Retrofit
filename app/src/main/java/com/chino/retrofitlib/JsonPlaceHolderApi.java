package com.chino.retrofitlib;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("posts")
    Call<Post> getPost();

    @GET("forecast")
    Call<Post> getfrorecast(
            @Query("id") Long cityid,
            @Query("appid") String key
    );
}
