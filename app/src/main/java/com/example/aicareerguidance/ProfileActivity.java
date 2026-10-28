package com.example.aicareerguidance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvInterest, tvSkill, tvCareer;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Connect XML Views
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvInterest = findViewById(R.id.tvInterest);
        tvSkill = findViewById(R.id.tvSkill);
        tvCareer = findViewById(R.id.tvCareer);
        btnLogout = findViewById(R.id.btnLogout);
        Button btnBackProfile = findViewById(R.id.btnBackProfile);

        // Read saved data
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);

        String name = preferences.getString("name", "Not Available");
        String email = preferences.getString("email", "Not Available");
        String interest = preferences.getString("interest", "Not Selected");
        String skill = preferences.getString("skill", "Not Selected");
        String career = preferences.getString("career", "Not Recommended");

        // Display data
        tvName.setText(name);
        tvEmail.setText(email);
        tvInterest.setText(interest);
        tvSkill.setText(skill);
        tvCareer.setText(career);

        // Back Button
        btnBackProfile.setOnClickListener(v -> finish());

        // Logout Button
        btnLogout.setOnClickListener(v -> {

            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        });
    }
}