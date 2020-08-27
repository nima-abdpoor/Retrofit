package com.chino.retrofitlib;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.text_result);
        GetPost(new Integer[]{1,2,3},"id","desc");
    }

    private void GetPost(Integer[] userId,String sort,String order) {
        Map<String, String> params = new HashMap<>();
        params.put("userId","1");
        params.put("_sort","id");
        params.put("_order","desc");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts(params);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    result.setText("Error:" + response.code());
                    return;
                }
                List<Post> body = response.body();
                for (Post post : body) {
                    String content = "";
                    content += "\n\nID : " + post.getId();
                    content += "\nUserID : " + post.getUserId();
                    content += "\ntitle : " + post.getTitle();
                    content += "\ntext : " + post.getBody();
                    result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
