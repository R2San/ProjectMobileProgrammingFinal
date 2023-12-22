package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView tvName,tvTune;

    ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvName = findViewById(R.id.tvName);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvName.setText(name);

        ivProfile = findViewById(R.id.ivProfile);

        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahProfile = new Intent(Profile.this, Profile.class);
                pindahProfile.putExtra("name", name);
                startActivity(pindahProfile);
            }
        });

        tvTune = findViewById(R.id.tvTune);
        tvTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahHome = new Intent(Profile.this, HomePage.class);
                pindahHome.putExtra("name", name);
                startActivity(pindahHome);
            }
        });

    }
}