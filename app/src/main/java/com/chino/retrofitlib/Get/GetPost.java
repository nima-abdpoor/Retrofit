package com.chino.retrofitlib.Get;

import com.chino.retrofitlib.JsonPlaceHolder.JsonPlaceHolderAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPost {

    private String result;

    GetObserver observer;
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    public void add(GetObserver observer){
        this.observer =observer;
    }

    public GetPost(JsonPlaceHolderAPI api) {
        this.jsonPlaceHolderAPI = api;
    }
    private void Notify(){
        observer.Update();
    }

    public void Get() {
        Map<String, String> params = new HashMap<>();
        params.put("userId", "1");
        params.put("_sort", "id");
        params.put("_order", "desc");
        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts(params);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    setResult("Error:" + response.code());
                }
                List<Post> body = response.body();
                for (Post post : body) {
                    String content = "";
                    content += "\n\nID : " + post.getId();
                    content += "\nUserID : " + post.getUserId();
                    content += "\ntitle : " + post.getTitle();
                    content += "\ntext : " + post.getBody();
                    setResult(content);
                }
                Notify();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Notify();
            }
        });
    }
    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        result += result;
        this.result = result;
    }
}
