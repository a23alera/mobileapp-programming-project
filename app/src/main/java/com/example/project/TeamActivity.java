package com.example.project;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class TeamActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        TextView tvName = findViewById(R.id.tvNameDetail);
        TextView tvLocation = findViewById(R.id.tvLocationDetail);
        TextView tvCost = findViewById(R.id.tvCostDetail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String location = intent.getStringExtra("Location");
        int cost = intent.getIntExtra("Cost", 0);

        tvName.setText(name);
        tvLocation.setText(location);
        tvCost.setText(String.format("%,d SEK", cost));
    }
}
