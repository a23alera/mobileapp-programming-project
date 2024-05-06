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
        textView.setText("Denna app är gjord för sånna som är intresserade inom hockey och Alex hockey league. I appen kan man välja ett av dom fem hockey lagen och få ut detaljer om det som hur mycket det är värt och deras hemma stad");
    }
}
