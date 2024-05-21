package com.example.project;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutlayout);

        TextView textView = findViewById(R.id.about_text_view);
        textView.setText("Denna app är skapad för alla som är intresserade av hockey och Alex Hockey League. Appen riktar sig till alla åldersgrupper. I appen kan användare välja ett av de fem hockeylagen och få detaljerad information om laget, inklusive dess värde och hemstad.");
    }
}
