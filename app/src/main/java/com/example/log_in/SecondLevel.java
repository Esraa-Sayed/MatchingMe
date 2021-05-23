package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondLevel extends AppCompatActivity implements View.OnClickListener {
Button angry_surprise;
Button angry_happiness;
Button angry_disgust;
Button fear_disgust;
Button fear_happy;
Button fear_surprise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_level);
        angry_surprise = findViewById(R.id.angry_surprise);
        angry_happiness = findViewById(R.id.angry_happiness);
        angry_disgust = findViewById(R.id.angry_disgust);
        fear_disgust = findViewById(R.id.fear_disgust);
        fear_happy = findViewById(R.id.fear_happy);
        fear_surprise = findViewById(R.id.fear_surprise);
        angry_surprise.setOnClickListener(this);
        angry_happiness.setOnClickListener(this);
        fear_disgust.setOnClickListener(this);
        fear_happy.setOnClickListener(this);
        fear_surprise.setOnClickListener(this);
        angry_disgust.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.angry_surprise) {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.angry_happiness) {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.angry_disgust) {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.fear_disgust) {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.fear_happy) {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId() == R.id.fear_surprise) {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();
        }
    }
}