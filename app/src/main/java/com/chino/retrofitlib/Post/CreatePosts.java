package com.chino.retrofitlib.Post;

import com.chino.retrofitlib.Get.Post;
import com.chino.retrofitlib.JsonPlaceHoder.JsonPlaceHolderAPI;
import com.chino.retrofitlib.MainActivity;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePosts {
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    public CreatePosts(JsonPlaceHolderAPI jsonPlaceHolderAPI) {
        this.jsonPlaceHolderAPI = jsonPlaceHolderAPI;
    }
    public void Create(){
        Map<String, String> fields =new HashMap<>();
        fields.put("userId","2");
        fields.put("title","android developer");
        fields.put("body","nima abdpoor");
        Call<Post> postCall=jsonPlaceHolderAPI.createPost(fields);
        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post post = response.body();
                String content = "";
                content += "Code : " + response.code();
                content += "\nID : " + post.getId();
                content += "\nUserID : " + post.getUserId();
                content += "\ntitle : " + post.getTitle();
                content += "\ntext : " + post.getBody();
                MainActivity.result.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                MainActivity.result.setText(t.getMessage());
            }
        });
    }
}
