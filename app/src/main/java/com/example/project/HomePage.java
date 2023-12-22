package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {



    RecyclerView rvSongs;

    TextView tvName, tvTune;

    ImageView ivProfile;

    //List of song
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        tvName = findViewById(R.id.tvName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvName.setText(name);

        ivProfile = findViewById(R.id.ivProfile);

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahProfile = new Intent(HomePage.this, Profile.class);
                pindahProfile.putExtra("name", name);
                startActivity(pindahProfile);
            }
        });

        tvTune = findViewById(R.id.tvTune);
        tvTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahHome = new Intent(HomePage.this, HomePage.class);
                pindahHome.putExtra("name", name);
                startActivity(pindahHome);
            }
        });

        songs = new ArrayList<>();
        songs.add(new Song("title01", "artist01", "genre01"));
        songs.add(new Song("title02", "artist01", "genre02"));
        songs.add(new Song("title03", "artist01", "genre01"));
        songs.add(new Song("title04", "artist01", "genre03"));
        songs.add(new Song("title05", "artist01", "genre02"));
        songs.add(new Song("title06", "artist01", "genre01"));
        songs.add(new Song("title07", "artist01", "genre04"));
        songs.add(new Song("title08", "artist01", "genre01"));


        rvSongs = findViewById(R.id.rvWordList);
        SongAdapter mSongAdapter = new SongAdapter(this, songs);
        rvSongs.setAdapter(mSongAdapter);
        rvSongs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}