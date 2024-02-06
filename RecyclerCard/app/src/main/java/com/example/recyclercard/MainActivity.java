package com.example.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Instagram> instagramList = new ArrayList<>();

        instagramList.add(new Instagram(R.drawable.slide1, "First Pic"));
        instagramList.add(new Instagram(R.drawable.slide2, "Second Pic"));
        instagramList.add(new Instagram(R.drawable.slide3, "Third Pic"));
        instagramList.add(new Instagram(R.drawable.slide4, "Fourth Pic"));

        //Config RV
        recyclerView = findViewById(R.id.RecyclerCard);
        //Performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new InstagramAdapter(instagramList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}