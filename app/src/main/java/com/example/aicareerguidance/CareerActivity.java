package com.example.aicareerguidance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CareerActivity extends AppCompatActivity {

    Spinner spInterest, spSkill;
    Button btnGetResult, btnRoadmap, btnBackHome;
    TextView tvCareerResult, tvCareerDetails;

    String[] interests = {
            "Programming",
            "Artificial Intelligence",
            "Data Science",
            "Android Development",
            "Web Development",
            "Cyber Security",
            "Cloud Computing",
            "UI/UX Design"
    };

    String[] skills = {
            "Beginner",
            "Intermediate",
            "Advanced"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);

        // Connect XML views
        spInterest = findViewById(R.id.spInterest);
        spSkill = findViewById(R.id.spSkill);

        btnGetResult = findViewById(R.id.btnGetResult);
        btnRoadmap = findViewById(R.id.btnRoadmap);
        btnBackHome = findViewById(R.id.btnBackHome);

        tvCareerResult = findViewById(R.id.tvCareerResult);
        tvCareerDetails = findViewById(R.id.tvCareerDetails);

        // Interest Spinner
        ArrayAdapter<String> interestAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, interests);
        interestAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spInterest.setAdapter(interestAdapter);

        // Skill Spinner
        ArrayAdapter<String> skillAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, skills);
        skillAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSkill.setAdapter(skillAdapter);

        // Load saved data
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String savedInterest = preferences.getString("interest", "");
        String savedSkill = preferences.getString("skill", "");
        String savedCareer = preferences.getString("career", "");

        if (!savedInterest.isEmpty()) {
            for (int i = 0; i < interests.length; i++) {
                if (interests[i].equals(savedInterest)) {
                    spInterest.setSelection(i);
                    break;
                }
            }
        }

        if (!savedSkill.isEmpty()) {
            for (int i = 0; i < skills.length; i++) {
                if (skills[i].equals(savedSkill)) {
                    spSkill.setSelection(i);
                    break;
                }
            }
        }

        if (!savedCareer.isEmpty()) {
            tvCareerResult.setText(savedCareer);
            showCareerDetails(savedCareer);
        }

        // Get Career Recommendation
        btnGetResult.setOnClickListener(view -> {
            String interest = spInterest.getSelectedItem().toString();
            String recommendedCareer = "";

            switch (interest) {
                case "Programming": recommendedCareer = "Software Developer"; break;
                case "Artificial Intelligence": recommendedCareer = "AI Engineer"; break;
                case "Data Science": recommendedCareer = "Data Scientist"; break;
                case "Android Development": recommendedCareer = "Android Developer"; break;
                case "Web Development": recommendedCareer = "Full Stack Developer"; break;
                case "Cyber Security": recommendedCareer = "Cyber Security Analyst"; break;
                case "Cloud Computing": recommendedCareer = "Cloud Engineer"; break;
                case "UI/UX Design": recommendedCareer = "UI/UX Designer"; break;
            }

            tvCareerResult.setText(recommendedCareer);
            showCareerDetails(recommendedCareer);

            // Save user's career information
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("interest", spInterest.getSelectedItem().toString());
            editor.putString("skill", spSkill.getSelectedItem().toString());
            editor.putString("career", recommendedCareer);
            editor.apply();
        });

        // Open Roadmap
        btnRoadmap.setOnClickListener(view -> {
            String career = tvCareerResult.getText().toString();
            if (career.equals("Your Recommendation") || career.isEmpty()) {
                Toast.makeText(this, "Please get a recommendation first", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(CareerActivity.this, RoadmapActivity.class);
            intent.putExtra("career", career);
            startActivity(intent);
        });

        // Back to Home
        btnBackHome.setOnClickListener(view -> {
            Intent intent = new Intent(CareerActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void showCareerDetails(String career) {
        String details = "";
        switch (career) {
            case "Software Developer":
                details = "Required Skills: Java, C++, DSA, SQL, Git\nSalary: ₹6 - ₹15 LPA\nScope: High demand in IT industry.";
                break;
            case "AI Engineer":
                details = "Required Skills: Python, Math, ML, DL, TensorFlow\nSalary: ₹8 - ₹25 LPA\nScope: Exponential growth in AI era.";
                break;
            case "Data Scientist":
                details = "Required Skills: Python, Statistics, SQL, Pandas, ML\nSalary: ₹7 - ₹20 LPA\nScope: Data-driven decision making is key.";
                break;
            case "Android Developer":
                details = "Required Skills: Java, Kotlin, XML, Android Studio, APIs\nSalary: ₹5 - ₹15 LPA\nScope: Mobile apps are everywhere.";
                break;
            case "Full Stack Developer":
                details = "Required Skills: HTML, CSS, JS, React, Node, MongoDB\nSalary: ₹5 - ₹15 LPA\nScope: Versatile web development needs.";
                break;
            case "Cyber Security Analyst":
                details = "Required Skills: Networking, Linux, Python, Hacking, PenTesting\nSalary: ₹6 - ₹20 LPA\nScope: Security is top priority for firms.";
                break;
            case "Cloud Engineer":
                details = "Required Skills: Linux, Networking, AWS/Azure, Docker, K8s\nSalary: ₹6 - ₹18 LPA\nScope: Moving everything to the cloud.";
                break;
            case "UI/UX Designer":
                details = "Required Skills: UI/UX, Figma, Wireframing, User Research\nSalary: ₹4 - ₹12 LPA\nScope: User experience defines product success.";
                break;
        }
        tvCareerDetails.setText(details);
    }
}
