package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.log_in.Expressions.Smile;

public class Exams extends AppCompatActivity implements View.OnClickListener  {
    Button finish;
    Button smile;
    Button Laugh;
    Button surprised;
    Button sad;
    Button anger;
    Button confusion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);
        finish = findViewById(R.id.finish3);
        smile = findViewById(R.id.SmileExam);
        Laugh = findViewById(R.id.laughExam);
        surprised = findViewById(R.id.surprisedExam);
        sad = findViewById(R.id.sadExam);
        confusion = findViewById(R.id.confusionExam);
        anger = findViewById(R.id.angerExam);
        finish.setOnClickListener(this);
        smile.setOnClickListener(this);
        Laugh.setOnClickListener(this);
        surprised.setOnClickListener(this);
        sad.setOnClickListener(this);
        anger.setOnClickListener(this);
        confusion.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == finish)
            finish();
        else if(view == anger)
        {
            Intent i = new Intent(this, AngryExam.class);
            startActivity(i);
        }
    }

}