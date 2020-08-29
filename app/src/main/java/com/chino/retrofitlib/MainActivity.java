package com.chino.retrofitlib;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chino.retrofitlib.Get.Comments;
import com.chino.retrofitlib.Get.GetObserver;
import com.chino.retrofitlib.Get.GetPost;
import com.chino.retrofitlib.Post.CreatePosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    public static TextView result;
    JsonPlaceHolderAPI jsonPlaceHolderAPI;
    GetPost getPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.text_result);
        prepreation();
        //Get();
        //GetPost(new Integer[]{1,2,3},"id","desc");
        //GetComments(2);
        //CreatePost();
        UpdatePost();
    }

    private void UpdatePost() {
        UpdatePost updatePost=new UpdatePost(jsonPlaceHolderAPI);
        updatePost.update();
    }

    private void CreatePost() {
        CreatePosts posts =new CreatePosts(this.jsonPlaceHolderAPI);
        posts.Create();
    }

    private void prepreation() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
    }

    private void Get() {
        GetPost post=new GetPost(jsonPlaceHolderAPI);
        GetObserver observer =new GetObserver(post);
        post.add(observer);
        post.Get();
    }


    private void GetComments(int id) {
        //Call<List<Comments>> call = jsonPlaceHolderAPI.getComments(id);
        Call<List<Comments>> call = jsonPlaceHolderAPI.getComments("/posts/2/comments");
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if (!response.isSuccessful()) {
                    result.setText("Error:" + response.code());
                    return;
                }
                List<Comments> body = response.body();
                for (Comments comments : body) {
                    String content = "";
                    content += "\n\nID : " + comments.getId();
                    content += "\nUserID : " + comments.getPostId();
                    content += "\nname : " + comments.getName();
                    content += "\nemail : " + comments.getEmail();
                    result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {

            }
        });
    }

}
