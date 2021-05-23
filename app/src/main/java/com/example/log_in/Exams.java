package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.log_in.AllExams.AngryExam;
import com.example.log_in.AllExams.ConfusionExam;
import com.example.log_in.AllExams.SadExam;
import com.example.log_in.AllExams.SmileExam;
import com.example.log_in.AllExams.SurprisedExam;
import com.example.log_in.AllExams.laughExam;

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
        else if(view == smile)
        {
            Intent i = new Intent(this, SmileExam.class);
            startActivity(i);
        }
        else if(view == confusion)
        {
            Intent i = new Intent(this, ConfusionExam.class);
            startActivity(i);
        }
        else if(view == Laugh)
        {
            Intent i = new Intent(this, laughExam.class);
            startActivity(i);
        }
        else if(view == sad)
        {
            Intent i = new Intent(this, SadExam.class);
            startActivity(i);
        }
        else if(view == surprised)
        {
            Intent i = new Intent(this, SurprisedExam.class);
            startActivity(i);
        }
    }

}