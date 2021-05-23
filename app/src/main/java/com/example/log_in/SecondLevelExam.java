package com.example.log_in;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.log_in.AllExams.AngryExam;

public class SecondLevelExam extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup Q1,Q2,Q3,Q4,Q5,Q6;
    RadioButton Q1Answer,Q2Answer,Q3Answer,Q4Answer,Q5Answer,Q6Answer;
    MediaPlayer Correct;
    MediaPlayer Wrong;
    int Score = 0 ;
    int ExamQ =0;
    Button score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_level_exam);
        Q1 = findViewById(R.id.Q1SL);Q2 = findViewById(R.id.Q2SL);Q3 = findViewById(R.id.Q3SL);
        Q4 = findViewById(R.id.Q4SL);Q5 = findViewById(R.id.Q5SL);Q6 = findViewById(R.id.Q6SL);
        score = findViewById(R.id.ScoreSL);
        Q1Answer = findViewById(R.id.Q1SLAnswer);Q2Answer = findViewById(R.id.Q2SLAnswer);Q3Answer = findViewById(R.id.Q3SLAnswer);
        Q4Answer = findViewById(R.id.Q4SLAnswer);Q5Answer = findViewById(R.id.Q5SLAnswer);Q6Answer = findViewById(R.id.Q6SLAnswer);
        Q1.setOnCheckedChangeListener(this);Q2.setOnCheckedChangeListener(this);
        Q3.setOnCheckedChangeListener(this);Q4.setOnCheckedChangeListener(this);
        Q5.setOnCheckedChangeListener(this);Q6.setOnCheckedChangeListener(this);

        Correct = MediaPlayer.create(this,R.raw.rightanswer);
        Wrong =  MediaPlayer.create(this,R.raw.wronganswer);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ExamQ < 6)
                {
                    Toast.makeText(SecondLevelExam.this,"جاوب علي جميع الاسأله",Toast.LENGTH_LONG).show();
                }
                else
                {
                    View view2 = getLayoutInflater().inflate(R.layout.score_exam, null);
                    TextView v = view2.findViewById(R.id.SocoreText);
                    v.setText(Score + " من 6");
                    AlertDialog.Builder builder;
                    AlertDialog dialog;
                    builder = new AlertDialog.Builder(SecondLevelExam.this);

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
            Q1Answer.setTextColor(0xFF2F6A16);
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
            Q2Answer.setTextColor(0xFF2F6A16);
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
            Q3Answer.setTextColor(0xFF2F6A16);
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
            Q4Answer.setTextColor(0xFF2F6A16);
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
            Q5Answer.setTextColor(0xFF2F6A16);
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
        if(group==Q6)
        {
            ExamQ++;
            Q6Answer.setTextColor(0xFF2F6A16);
            if(checkedId == Q6Answer.getId()) {
                Score++;
                Correct.start();
            }
            else
            {
                Wrong.start();
            }
            for(int i = 0; i < Q6.getChildCount(); i++)
                Q6.getChildAt(i).setEnabled(false);
        }

    }
}