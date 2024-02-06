package com.example.recyclercard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InstagramAdapter extends RecyclerView.Adapter<InstagramAdapter.InstagramViewHolder> {

    private ArrayList<Instagram> mInstagramList;

    public static class InstagramViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView;
        public InstagramViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
        }
    }

    public InstagramAdapter(ArrayList<Instagram> instagramList){
        mInstagramList = instagramList;
    }


    @NonNull
    @Override
    public InstagramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.instagram,parent,false);
        InstagramViewHolder instagramViewHolder = new InstagramViewHolder(view);
        return instagramViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InstagramViewHolder instagramViewHolder, int i) {
        Instagram currentItem = mInstagramList.get(i);
        InstagramViewHolder.imageView.setImageResource(currentItem.getMyImageSource());
        InstagramViewHolder.textView.setText(currentItem.getText());
    }

    @Override
    public int getItemCount() {
        return mInstagramList.size();
    }

}
