package com.example.aicareerguidance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    LinearLayout cardRecommendation, cardRoadmap, cardProfile, cardLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Connect XML with Java
        cardRecommendation = findViewById(R.id.cardRecommendation);
        cardRoadmap = findViewById(R.id.cardRoadmap);
        cardProfile = findViewById(R.id.cardProfile);
        cardLogout = findViewById(R.id.cardLogout);

        // Career Recommendation
        cardRecommendation.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, CareerActivity.class);
            startActivity(intent);
        });

        // Career Roadmap
        cardRoadmap.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, RoadmapActivity.class);
            startActivity(intent);
        });

        // Profile
        cardProfile.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // Logout
        cardLogout.setOnClickListener(view -> {
            Toast.makeText(HomeActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}