package com.chino.retrofitlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import okhttp3.internal.concurrent.Task;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
