package com.example.jsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
        Students one = new Students("Aswin",5,"aswin@gmail.com");

        String json = gson.toJson(one);
        Log.i("TEST",json);

    }
}