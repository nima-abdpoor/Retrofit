package com.chino.retrofitlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

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
        result=findViewById(R.id.text_result);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonapi=retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call=jsonapi.getfrorecast((long) 524901,"b34d97936eaadfa405d3b9b18db6a0ff");
       call.enqueue(new Callback<Post>() {
           @Override
           public void onResponse(Call<Post> call, Response<Post> response) {
               Post post = response.body();
               Log.i("sfsfas", post.getCod());
           }

           @Override
           public void onFailure(Call<Post> call, Throwable t) {
               Log.i("sfsfas", t.getMessage());
           }
       });
    }
}
