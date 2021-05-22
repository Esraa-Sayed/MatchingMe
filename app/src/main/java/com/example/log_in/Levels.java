package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.log_in.Expressions.Anger;
import com.example.log_in.Expressions.Confusion;
import com.example.log_in.Expressions.Sad;
import com.example.log_in.Expressions.Smile;
import com.example.log_in.Expressions.Surprised;
import com.example.log_in.Expressions.laugh;

public class Levels extends AppCompatActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_levels);
        finish = findViewById(R.id.finish2);
        smile = findViewById(R.id.Smile);
        Laugh = findViewById(R.id.laugh);
        surprised = findViewById(R.id.surprised);
        sad = findViewById(R.id.sad);
        confusion = findViewById(R.id.confusion);
        anger = findViewById(R.id.anger);
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
        else if(view == smile)
        {
            Intent i = new Intent(this, Smile.class);
            startActivity(i);
        }
        else if(view == Laugh)
        {
            Intent i = new Intent(this, laugh.class);
            startActivity(i);
        }
        else if(view == surprised)
        {
            Intent i = new Intent(this, Surprised.class);
            startActivity(i);
        }
        else if(view == sad)
        {
            Intent i = new Intent(this, Sad.class);
            startActivity(i);
        }
        else if(view == anger)
        {
            Intent i = new Intent(this, Anger.class);
            startActivity(i);
        }
        else if(view == confusion)
        {
            Intent i = new Intent(this, Confusion.class);
            startActivity(i);
        }
    }
}