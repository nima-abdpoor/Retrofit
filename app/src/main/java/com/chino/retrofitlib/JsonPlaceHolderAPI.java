package com.chino.retrofitlib;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

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

    @GET("Post/{id}/comments")
    Call<List<Comments>> getComments(@Path("id" )int id);

    @GET
    Call<List<Comments>> getComments(@Url String url);
}
