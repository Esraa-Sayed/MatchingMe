package com.example.log_in.AllExams;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.log_in.R;

public class SadExam extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    ImageView Q1Answerimg,image2Q1,image3Q1;
    ImageView Q2Answerimg,image2Q2,image3Q2;
    ImageView Q3Answerimg,image2Q3,image3Q3;
    ImageView Q4Answerimg,image2Q4,image3Q4;
    ImageView Q5Answerimg,image2Q5,image3Q5;
    TextView TheQuastion;
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
        setContentView(R.layout.all_exams);
        Q1 = findViewById(R.id.Q1);Q2 = findViewById(R.id.Q2);Q3 = findViewById(R.id.Q3);Q4 = findViewById(R.id.Q4);Q5 = findViewById(R.id.Q5);
        score = findViewById(R.id.Score);
        Q1Answer = findViewById(R.id.Q1Answer);Q2Answer = findViewById(R.id.Q2Answer);Q3Answer = findViewById(R.id.Q3Answer);Q4Answer = findViewById(R.id.Q4Answer);Q5Answer = findViewById(R.id.Q5Answer);
        Q1.setOnCheckedChangeListener(this);Q2.setOnCheckedChangeListener(this);
        Q3.setOnCheckedChangeListener(this);Q4.setOnCheckedChangeListener(this);Q5.setOnCheckedChangeListener(this);
        Correct = MediaPlayer.create(this,R.raw.rightanswer);
        Wrong =  MediaPlayer.create(this,R.raw.wronganswer);
        putImg();

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ExamQ < 5)
                {
                    Toast.makeText(SadExam.this,"جاوب علي جميع الاسأله",Toast.LENGTH_LONG).show();
                }
                else
                {
                    View view2 = getLayoutInflater().inflate(R.layout.score_exam, null);
                    TextView v = view2.findViewById(R.id.SocoreText);
                    v.setText(Score + " من 5");
                    AlertDialog.Builder builder;
                    AlertDialog dialog;
                    builder = new AlertDialog.Builder(SadExam.this);

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
    void putImg()
    {
        TheQuastion = findViewById(R.id.TheQuastion);
        TheQuastion.setText(R.string.chooseSadFace);
        Q1Answerimg = findViewById(R.id.Q1Answerimg);  Q1Answerimg.setImageResource(R.drawable.sad2);
        image2Q1 = findViewById(R.id.image2Q1);        image2Q1.setImageResource(R.drawable.angery2);
        image3Q1 = findViewById(R.id.image3Q1);        image3Q1.setImageResource(R.drawable.happy2);

        Q2Answerimg = findViewById(R.id.Q2Answerimg);   Q2Answerimg.setImageResource(R.drawable.sadkind2);
        image2Q2 = findViewById(R.id.image2Q2);         image2Q2.setImageResource(R.drawable.smile3);
        image3Q2 = findViewById(R.id.image3Q2);         image3Q2.setImageResource(R.drawable.smile6);

        Q3Answerimg = findViewById(R.id.Q3Answerimg);    Q3Answerimg.setImageResource(R.drawable.sad_cartoon4);
        image2Q3 = findViewById(R.id.image2Q3);           image2Q3.setImageResource(R.drawable.anger_carton3);
        image3Q3 = findViewById(R.id.image3Q3);            image3Q3.setImageResource(R.drawable.angry_cartoon4);


        Q4Answerimg = findViewById(R.id.Q4Answerimg);    Q4Answerimg.setImageResource(R.drawable.sad_cartoon3);
        image2Q4 = findViewById(R.id.image2Q4);           image2Q4.setImageResource(R.drawable.happy_cartoon2);
        image3Q4 = findViewById(R.id.image3Q4);            image3Q4.setImageResource(R.drawable.happy_cartoon3);


        Q5Answerimg = findViewById(R.id.Q5Answerimg);    Q5Answerimg.setImageResource(R.drawable.sad_cartoon2);
        image2Q5 = findViewById(R.id.image2Q5);           image2Q5.setImageResource(R.drawable.worry_carton);
        image3Q5 = findViewById(R.id.image3Q5);            image3Q5.setImageResource(R.drawable.angry_cartoon5);
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