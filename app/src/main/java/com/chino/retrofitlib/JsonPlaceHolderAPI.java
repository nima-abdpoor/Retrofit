package com.chino.retrofitlib;

import com.chino.retrofitlib.Get.Comments;
import com.chino.retrofitlib.Get.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
       @Field("userId") int id,
       @Field("title") String title,
       @Field("body") String text
    );

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String , String> fields);
}
