package com.chino.retrofitlib.Delete;


import com.chino.retrofitlib.JsonPlaceHoder.JsonPlaceHolderAPI;
import com.chino.retrofitlib.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeletePost {
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    public DeletePost(JsonPlaceHolderAPI jsonPlaceHolderAPI) {
        this.jsonPlaceHolderAPI = jsonPlaceHolderAPI;
    }

    public void delete() {
        Call<Void> call = jsonPlaceHolderAPI.delete(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                MainActivity.result.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                MainActivity.result.setText("failed: " + t.getMessage());
            }
        });
    }
}
