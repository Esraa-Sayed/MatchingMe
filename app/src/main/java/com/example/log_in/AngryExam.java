package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AngryExam extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup Q1,Q2,Q3,Q4,Q5;
    RadioButton Q1Answer,Q2Answer,Q3Answer,Q4Answer,Q5Answer;
    MediaPlayer Correct;
    MediaPlayer Wrong;
    int Score = 0 ;
    int ExamQ =0;
    Button score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.angry_exam);
        Q1 = findViewById(R.id.Q1);
        Q2 = findViewById(R.id.Q2);
        Q3 = findViewById(R.id.Q3);
        Q4 = findViewById(R.id.Q4);
        Q5 = findViewById(R.id.Q5);
        score = findViewById(R.id.Score);
        Q1Answer = findViewById(R.id.Q1Answer);
        Q2Answer = findViewById(R.id.Q2Answer);
        Q3Answer = findViewById(R.id.Q3Answer);
        Q4Answer = findViewById(R.id.Q4Answer);
        Q5Answer = findViewById(R.id.Q5Answer);
        Q1.setOnCheckedChangeListener(this);
        Q2.setOnCheckedChangeListener(this);
        Q3.setOnCheckedChangeListener(this);
        Q4.setOnCheckedChangeListener(this);
        Q5.setOnCheckedChangeListener(this);
        Correct = MediaPlayer.create(this,R.raw.rightanswer);
        Wrong =  MediaPlayer.create(this,R.raw.wronganswer);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ExamQ < 5)
                {
                    Toast.makeText(AngryExam.this,"جاوب علي جميع الاسأله",Toast.LENGTH_LONG).show();
                }
                else
                {
                    View view2 = getLayoutInflater().inflate(R.layout.score_exam, null);
                    TextView v = view2.findViewById(R.id.SocoreText);
                    v.setText(Score + " من 5");
                    AlertDialog.Builder builder;
                    AlertDialog dialog;
                    builder = new AlertDialog.Builder(AngryExam.this);

                    builder.setCancelable(false);
                   builder.setView(view2);
                    builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    });
                    dialog =builder.create();
                    dialog.show();
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group==Q1)
        {
            ExamQ++;
            Q1Answer.setText("الصحيحة");
            if(checkedId == Q1Answer.getId()) {
                Score++;
                Correct.start();
            }
            else
            {
                Wrong.start();
            }
            for(int i = 0; i < Q1.getChildCount(); i++)
                Q1.getChildAt(i).setEnabled(false);
        }
        if(group==Q2)
        {
            ExamQ++;
            Q2Answer.setText("الصحيحة");
            if(checkedId == Q2Answer.getId()) {
                Score++;
                Correct.start();
            }
            else
            {
                Wrong.start();
            }
            for(int i = 0; i < Q2.getChildCount(); i++)
                Q2.getChildAt(i).setEnabled(false);
        }
        if(group==Q3)
        {
            ExamQ++;
            Q3Answer.setText("الصحيحة");
            if(checkedId == Q3Answer.getId()) {
                Score++;
                Correct.start();
            }
            else
            {
                Wrong.start();
            }
            for(int i = 0; i < Q3.getChildCount(); i++)
                Q3.getChildAt(i).setEnabled(false);
        }
        if(group==Q4)
        {
            ExamQ++;
            Q4Answer.setText("الصحيحة");
            if(checkedId == Q4Answer.getId()) {
                Score++;
                Correct.start();
            }
            else
            {
                Wrong.start();
            }
            for(int i = 0; i < Q4.getChildCount(); i++)
                Q4.getChildAt(i).setEnabled(false);
        }
        if(group==Q5)
        {
            ExamQ++;
            Q5Answer.setText("الصحيحة");
            if(checkedId == Q5Answer.getId()) {
                Score++;
                Correct.start();
            }
            else
            {
                Wrong.start();
            }
            for(int i = 0; i < Q5.getChildCount(); i++)
                Q5.getChildAt(i).setEnabled(false);
        }

    }
}