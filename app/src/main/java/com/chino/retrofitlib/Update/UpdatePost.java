package com.chino.retrofitlib.Update;

import com.chino.retrofitlib.Get.Post;
import com.chino.retrofitlib.JsonPlaceHolder.JsonPlaceHolderAPI;
import com.chino.retrofitlib.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePost {
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    public UpdatePost(JsonPlaceHolderAPI jsonPlaceHolderAPI) {
        this.jsonPlaceHolderAPI = jsonPlaceHolderAPI;
    }

    public void update() {
        Post post = new Post(2, null, "nima");
        Call<Post> call = jsonPlaceHolderAPI.putPosts("abc",12, post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    MainActivity.result.setText("Code: " + response.code());
                    return;
                }
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
                MainActivity.result.setText("failed: " + t.getMessage());
            }
        });
    }
}
