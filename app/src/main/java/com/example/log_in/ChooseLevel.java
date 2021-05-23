package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseLevel extends AppCompatActivity implements View.OnClickListener {
Button finish;
Button firstLevel;
Button secondLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_level);
        finish = findViewById(R.id.finish);
        firstLevel = findViewById(R.id.firstLevel);
        secondLevel = findViewById(R.id.secondLevel);
        firstLevel.setOnClickListener(this);
        secondLevel.setOnClickListener(this);

        finish.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == firstLevel)
        {
            Intent i = new Intent(this,Levels.class);
            startActivity(i);
        }
        if(view == secondLevel)
        {
            Intent i = new Intent(this,SecondLevel.class);
            startActivity(i);
        }
       else if(view == finish)
        {
            finish();
        }
    }
}