package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.log_in.CmplexExpr.angry_surprise;

public class SecondLevel extends AppCompatActivity implements View.OnClickListener {
Button angry_surprise;
Button angry_happiness;
Button angry_disgust;
Button fear_disgust;
Button fear_happy;
Button fear_surprise;
Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_level);
        angry_surprise = findViewById(R.id.angry_surprise);
        angry_happiness = findViewById(R.id.angry_happiness);
        angry_disgust = findViewById(R.id.angry_disgust);
        fear_disgust = findViewById(R.id.fear_disgust);
        fear_happy = findViewById(R.id.fear_happy);
        finish = findViewById(R.id.finish2);
        fear_surprise = findViewById(R.id.fear_surprise);
        angry_surprise.setOnClickListener(this);
        angry_happiness.setOnClickListener(this);
        fear_disgust.setOnClickListener(this);
        fear_happy.setOnClickListener(this);
        fear_surprise.setOnClickListener(this);
        angry_disgust.setOnClickListener(this);
        finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.angry_surprise) {
            Intent i = new Intent(this, com.example.log_in.CmplexExpr.angry_surprise.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.angry_happiness) {
            Intent i = new Intent(this, com.example.log_in.CmplexExpr.angry_happiness.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.angry_disgust) {
            Intent i = new Intent(this, com.example.log_in.CmplexExpr.angry_disgust.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.fear_disgust) {
            Intent i = new Intent(this, com.example.log_in.CmplexExpr.fear_disgust.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.fear_happy) {
            Intent i = new Intent(this, com.example.log_in.CmplexExpr.fear_happy.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.fear_surprise) {
            Intent i = new Intent(this, com.example.log_in.CmplexExpr.fear_surprise.class);
            startActivity(i);
        }
        else if (view.getId() == R.id.finish2) {
           finish();}
    }
}