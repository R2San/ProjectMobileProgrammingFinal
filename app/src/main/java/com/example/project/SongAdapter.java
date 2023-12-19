package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter {

    LayoutInflater mLayoutInfLater;
    ArrayList<Song> mySongList;

    public SongAdapter (Context ctx, ArrayList<Song> songs){
        mLayoutInfLater = LayoutInflater.from(ctx);
        mySongList = songs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myItemView = mLayoutInfLater.inflate(R.layout.song_card, parent, false);
        return new SongViewHolder(myItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String title = mySongList.get(position).title;
        String artist= mySongList.get(position).artist;
        TextView tvTitle = holder.itemView.findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        TextView tvArtist = holder.itemView.findViewById(R.id.tvArtist);
        tvArtist.setText(artist);
    }

    @Override
    public int getItemCount() {
        return mySongList.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        SongAdapter adapter;

        public SongViewHolder(@NonNull View itemView, SongAdapter adapter) {
            super(itemView);

            this.adapter = adapter;
        }
    }

}
