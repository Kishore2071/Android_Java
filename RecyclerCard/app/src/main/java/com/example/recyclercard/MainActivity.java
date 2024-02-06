package com.example.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
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

        ArrayList<Instagram> data = new ArrayList<>();

        data.add(new Instagram(R.drawable.slide1, "First Pic"));
        data.add(new Instagram(R.drawable.slide2, "Second Pic"));
        data.add(new Instagram(R.drawable.slide3, "Third Pic"));
        data.add(new Instagram(R.drawable.slide4, "Fourth Pic"));

    }
}