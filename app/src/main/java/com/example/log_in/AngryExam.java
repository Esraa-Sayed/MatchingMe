package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AngryExam extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    ImageView img1,img2,img3;
    RadioGroup Q;
    TextView TheQuastion;
    RadioButton Q1Ch1,Q1Ch2,Q1Ch3;
    MediaPlayer Correct;
    MediaPlayer Wrong;
    Runnable runnable = null;
    Thread thread;
    int countQ = 0,i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angry_exam);
        img1 = findViewById(R.id.Img1);
        img2 = findViewById(R.id.Img2);
        img3 = findViewById(R.id.Img3);
        TheQuastion = findViewById(R.id.TheQuastion);
        Q = findViewById(R.id.Q);
        Q1Ch1=findViewById(R.id.Q1Ch1);
        Q1Ch2=findViewById(R.id.Q1Ch2);
        Q1Ch3=findViewById(R.id.Q1Ch3);
        createCard(i);
        Q.setOnCheckedChangeListener(this);
        Correct = MediaPlayer.create(this,R.raw.rightanswer);
        Wrong =  MediaPlayer.create(this,R.raw.wronganswer);
    }
    private void createCard(int i) {
        TheQuastion.setText("أختر الوجهه الغاضب");
        img1.setImageResource( GlobalVar.Anger.get(i));
        img2.setImageResource(GlobalVar.confusion.get(i));
        img3.setImageResource(GlobalVar.confusion.get(i+1));
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        //   Toast.makeText(this,checkedId+"",Toast.LENGTH_SHORT).show();
        if(checkedId == Q1Ch1.getId()) {
            Correct.start();

           if(! Correct.isPlaying())
           {
               i++;
               createCard(i);
           }
        }
        else {
            Toast.makeText(this, "حاول مرة اخري", Toast.LENGTH_SHORT).show();
            Wrong.start();
        }

    }
}