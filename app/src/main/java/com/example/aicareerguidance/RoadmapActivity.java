package com.example.aicareerguidance;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RoadmapActivity extends AppCompatActivity {

    TextView tvRoadmapTitle, tvRoadmap;
    Button btnBackCareer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);

        tvRoadmapTitle = findViewById(R.id.tvRoadmapTitle);
        tvRoadmap = findViewById(R.id.tvRoadmap);
        btnBackCareer = findViewById(R.id.btnBackCareer);

        String career = getIntent().getStringExtra("career");
        if (career == null || career.isEmpty()) {
            career = "Software Developer";
        }

        tvRoadmapTitle.setText(career + " Roadmap");
        tvRoadmap.setText(getRoadmapText(career));

        btnBackCareer.setOnClickListener(v -> finish());
    }

    private String getRoadmapText(String career) {
        switch (career) {
            case "Software Developer":
                return "1. Learn C/C++ or Java Fundamentals\n" +
                        "2. Master Data Structures and Algorithms (DSA)\n" +
                        "3. Learn Object-Oriented Programming (OOPs)\n" +
                        "4. Understand Database Management (SQL/NoSQL)\n" +
                        "5. Learn Version Control (Git & GitHub)\n" +
                        "6. Build Mini Projects (Console Apps, Simple Tools)\n" +
                        "7. Tools: VS Code, IntelliJ, Git\n" +
                        "8. Apply for Software Engineering Internships\n" +
                        "Goal: Become a Proficient Software Developer";

            case "AI Engineer":
                return "1. Master Python Programming\n" +
                        "2. Learn Mathematics (Linear Algebra, Calculus, Statistics)\n" +
                        "3. Learn Data Handling (NumPy, Pandas, Matplotlib)\n" +
                        "4. Master Machine Learning Algorithms\n" +
                        "5. Dive into Deep Learning (Neural Networks, CNN, RNN)\n" +
                        "6. Learn Frameworks (TensorFlow or PyTorch)\n" +
                        "7. Tools: Jupyter Notebook, Google Colab\n" +
                        "8. Build AI Models & Participate in Kaggle Competitions\n" +
                        "9. Internship: AI/ML Research Intern\n" +
                        "Goal: Become an AI Engineer";

            case "Data Scientist":
                return "1. Learn Python or R for Data Science\n" +
                        "2. Master Statistics and Probability\n" +
                        "3. Advanced SQL for Data Extraction\n" +
                        "4. Data Cleaning and Preprocessing Techniques\n" +
                        "5. Exploratory Data Analysis (EDA)\n" +
                        "6. Learn Machine Learning for Prediction\n" +
                        "7. Tools: Tableau, Power BI, Excel, Pandas\n" +
                        "8. Build Data Stories and Dashboards\n" +
                        "9. Internship: Data Analyst or Data Science Intern\n" +
                        "Goal: Become a Data Scientist";

            case "Android Developer":
                return "1. Learn Java or Kotlin Fundamentals\n" +
                        "2. Understand Android Architecture Components\n" +
                        "3. Master UI/UX Design with XML or Jetpack Compose\n" +
                        "4. Learn Networking (Retrofit, OkHttp)\n" +
                        "5. Integrate Firebase Services (Auth, Database)\n" +
                        "6. Tools: Android Studio, Postman, Figma\n" +
                        "7. Build and Publish Apps on Play Store\n" +
                        "8. Internship: Android App Developer Intern\n" +
                        "Goal: Become a Professional Android Developer";

            case "Full Stack Developer":
                return "1. Frontend: HTML, CSS, JavaScript (ES6+)\n" +
                        "2. Frontend Framework: React, Angular, or Vue\n" +
                        "3. Backend: Node.js, Python (Django/Flask), or Java (Spring)\n" +
                        "4. Database: MongoDB, PostgreSQL, or MySQL\n" +
                        "5. Learn RESTful APIs and Authentication (JWT)\n" +
                        "6. Tools: VS Code, Docker, AWS/Heroku\n" +
                        "7. Build a MERN/MEAN Stack Application\n" +
                        "8. Internship: Web Development Intern\n" +
                        "Goal: Become a Full Stack Web Developer";

            case "Cyber Security Analyst":
                return "1. Understand Computer Networking (TCP/IP, DNS)\n" +
                        "2. Learn Linux Command Line & Scripting\n" +
                        "3. Master Security Fundamentals (CIA Triad, Cryptography)\n" +
                        "4. Learn Ethical Hacking & Penetration Testing\n" +
                        "5. Understand Web Application Security (OWASP Top 10)\n" +
                        "6. Tools: Kali Linux, Wireshark, Metasploit, Nmap\n" +
                        "7. Get Certified (CompTIA Security+, CEH)\n" +
                        "8. Internship: Information Security Intern\n" +
                        "Goal: Become a Cyber Security Analyst";

            case "Cloud Engineer":
                return "1. Learn Basics of Virtualization & Networking\n" +
                        "2. Master Linux System Administration\n" +
                        "3. Choose a Cloud Provider (AWS, Azure, or GCP)\n" +
                        "4. Learn Infrastructure as Code (Terraform, Ansible)\n" +
                        "5. Master Containerization (Docker & Kubernetes)\n" +
                        "6. Tools: AWS Console, CLI, Jenkins, Docker\n" +
                        "7. Build Scalable Cloud Infrastructures\n" +
                        "8. Internship: Cloud Operations or DevOps Intern\n" +
                        "Goal: Become a Cloud Engineer";

            case "UI/UX Designer":
                return "1. Understand Design Principles (Color, Typography, Layout)\n" +
                        "2. Learn User Research and Persona Building\n" +
                        "3. Master Wireframing and Prototyping\n" +
                        "4. Learn Visual Design Tools (Figma, Adobe XD)\n" +
                        "5. Understand Interaction Design and Usability Testing\n" +
                        "6. Tools: Figma, Sketch, InVision, Adobe Creative Suite\n" +
                        "7. Create a Strong Portfolio on Behance/Dribbble\n" +
                        "8. Internship: UI/UX Design Intern\n" +
                        "Goal: Become a UI/UX Designer";

            default:
                return "Roadmap details coming soon for this career path.";
        }
    }
}
