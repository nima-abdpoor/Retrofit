package com.chino.retrofitlib;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderAPI {
    @GET("Posts")
    Call<List<Post>> getPosts(
            @Query(("userId")) Integer[] userId,
            @Query(("_sort")) String sort,
            @Query(("_order")) String order
    );

    @GET("Posts")
    Call<List<Post>> getPosts(
            @QueryMap Map<String, String> parameters
            );
}
