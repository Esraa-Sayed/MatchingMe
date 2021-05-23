package com.example.log_in;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity implements View.OnClickListener , RadioGroup.OnCheckedChangeListener {
    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
   /* private BankofQuestions BOQ=new BankofQuestions();
    private String mAnswer;
    private int QN=0;
    private int NUMBER_OF_Q_TO_ADD=5;
    private  int N,counter=0,flag=0;
    private   int A[]= new int[5];
RadioGroup Q1,Q2,Q3,Q4,Q5;
RadioButton Q1Ch1,Q1Ch2,Q1Ch3;
RadioButton Q2Ch1,Q2Ch2,Q2Ch3;
RadioButton Q3Ch1,Q3Ch2,Q3Ch3;
RadioButton Q4Ch1,Q4Ch2,Q4Ch3;
RadioButton Q5Ch1,Q5Ch2,Q5Ch3;
Button S;
Button Btn;
TextView TVQ1,TVQ2,TVQ3,TVQ4,TVQ5;
int Res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q);
        S=findViewById(R.id.B2);
        Q1=findViewById(R.id.Q1);
        Q2=findViewById(R.id.Q2);
        Q3=findViewById(R.id.Q3);
        Q4=findViewById(R.id.Q4);
        Q5=findViewById(R.id.Q5);

        TVQ1=findViewById(R.id.TVQ1);
        TVQ2=findViewById(R.id.TVQ2);
        TVQ3=findViewById(R.id.TVQ3);
        TVQ4=findViewById(R.id.TVQ4);
        TVQ5=findViewById(R.id.TVQ5);

        Q1Ch1=findViewById(R.id.Q1Ch1);
        Q1Ch2=findViewById(R.id.Q1Ch2);
        Q1Ch3=findViewById(R.id.Q1Ch3);

        Q2Ch1=findViewById(R.id.Q2Ch1);
        Q2Ch2=findViewById(R.id.Q2Ch2);
        Q2Ch3=findViewById(R.id.Q2Ch3);

        Q3Ch1=findViewById(R.id.Q3Ch1);
        Q3Ch2=findViewById(R.id.Q3Ch2);
        Q3Ch3=findViewById(R.id.Q3Ch3);

        Q4Ch1=findViewById(R.id.Q4Ch1);
        Q4Ch2=findViewById(R.id.Q4Ch2);
        Q4Ch3=findViewById(R.id.Q4Ch3);

        Q5Ch1=findViewById(R.id.Q5Ch1);
        Q5Ch2=findViewById(R.id.Q5Ch2);
        Q5Ch3=findViewById(R.id.Q5Ch3);

        Btn=findViewById(R.id.BACK);
        Btn.setOnClickListener( this);
        S.setOnClickListener(this);
        Q1.setOnCheckedChangeListener(this);
        Q2.setOnCheckedChangeListener(this);
        Q3.setOnCheckedChangeListener(this);
        Q4.setOnCheckedChangeListener(this);
        Q5.setOnCheckedChangeListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        counter=0;
        while(counter!=5)
        {   flag=0;
            N= ((int) (Math.random() * 10) %NUMBER_OF_Q_TO_ADD );
            for (int i=0;i<counter;i++)
            {
                if(A[i]==N)flag=1;
            }
            if(flag==0)A[counter++]=N;
        }
        TVQ1.setText("Q1) "+BOQ.getQuestion(A[0]));
        TVQ2.setText("Q2) "+BOQ.getQuestion(A[1]));
        TVQ3.setText("Q3) "+BOQ.getQuestion(A[2]));
        TVQ4.setText("Q4) "+BOQ.getQuestion(A[3]));
        TVQ5.setText("Q5) "+BOQ.getQuestion(A[4]));

        Q1Ch1.setText(BOQ.getChoice1(A[0]));
        Q1Ch2.setText(BOQ.getChoice2(A[0]));
        Q1Ch3.setText(BOQ.getChoice3(A[0]));

        Q2Ch1.setText(BOQ.getChoice1(A[1]));
        Q2Ch2.setText(BOQ.getChoice2(A[1]));
        Q2Ch3.setText(BOQ.getChoice3(A[1]));

        Q3Ch1.setText(BOQ.getChoice1(A[2]));
        Q3Ch2.setText(BOQ.getChoice2(A[2]));
        Q3Ch3.setText(BOQ.getChoice3(A[2]));

        Q4Ch1.setText(BOQ.getChoice1(A[3]));
        Q4Ch2.setText(BOQ.getChoice2(A[3]));
        Q4Ch3.setText(BOQ.getChoice3(A[3]));

        Q5Ch1.setText(BOQ.getChoice1(A[4]));
        Q5Ch2.setText(BOQ.getChoice2(A[4]));
        Q5Ch3.setText(BOQ.getChoice3(A[4]));

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(group==Q1)
        {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            if(BOQ.getCorrectAnswer(A[0])==selectedRadioButtonText) {
                Res++;
               Toast.makeText(Quiz.this,"Right Answer",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(Quiz.this,"Wrong Answer",Toast.LENGTH_LONG).show();
            }
            for(int i = 0; i < Q1.getChildCount(); i++)
                Q1.getChildAt(i).setEnabled(false);
        }
       else  if(group==Q2)
        {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            if(BOQ.getCorrectAnswer(A[1])==selectedRadioButtonText) {
                Res++;
                Toast.makeText(Quiz.this,"Right Answer",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(Quiz.this,"Wrong Answer",Toast.LENGTH_LONG).show();
            }
            for(int i = 0; i < Q2.getChildCount(); i++)
                Q2.getChildAt(i).setEnabled(false);
        }
        else  if(group==Q3)
        {RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            if(BOQ.getCorrectAnswer(A[2])==selectedRadioButtonText)
            {
                Res++;
                Toast.makeText(Quiz.this,"Right Answer",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(Quiz.this,"Wrong Answer",Toast.LENGTH_LONG).show();
            }
            for(int i = 0; i < Q3.getChildCount(); i++)
                Q3.getChildAt(i).setEnabled(false);
        }
        else  if(group==Q4)
        {RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            if(BOQ.getCorrectAnswer(A[3])==selectedRadioButtonText) {
                Res++;
                Toast.makeText(Quiz.this,"Right Answer",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(Quiz.this,"Wrong Answer",Toast.LENGTH_LONG).show();
            }
            for(int i = 0; i < Q4.getChildCount(); i++)
                Q4.getChildAt(i).setEnabled(false);
        }
        else  if(group==Q5)
        {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedRadioButtonText = selectedRadioButton.getText().toString();
            if(BOQ.getCorrectAnswer(A[4])==selectedRadioButtonText) {
                Res++;
                Toast.makeText(Quiz.this,"Right Answer",Toast.LENGTH_LONG).show();
            }
            else
            {
               Toast.makeText(Quiz.this,"Wrong Answer",Toast.LENGTH_LONG).show();
            }
            for(int i = 0; i < Q5.getChildCount(); i++)
                Q5.getChildAt(i).setEnabled(false);
        }
        if (Q1.getCheckedRadioButtonId() != -1&&Q2.getCheckedRadioButtonId()!=-1&&Q3.getCheckedRadioButtonId()!=-1&&Q4.getCheckedRadioButtonId()!=-1&&Q5.getCheckedRadioButtonId()!=-1)
        {
            S.setEnabled(true);
            S.setBackgroundColor(Color.parseColor("#4C4D51"));
            S.setTextColor(Color.parseColor("#F9FBFB"));
        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
Q1.clearCheck();
Q2.clearCheck();
Q3.clearCheck();
Q4.clearCheck();
Q5.clearCheck();
        for(int i = 0; i < Q1.getChildCount(); i++) {
            Q1.getChildAt(i).setEnabled(true);
            Q2.getChildAt(i).setEnabled(true);
            Q3.getChildAt(i).setEnabled(true);
            Q4.getChildAt(i).setEnabled(true);
            Q5.getChildAt(i).setEnabled(true);
        }
        Res=0;
        S.setEnabled(false);
        S.setBackgroundColor(Color.parseColor("#4D4C4D51"));
        S.setTextColor(Color.parseColor("#4DF9FBFB"));
    }

    @Override
    public void onClick(View v) {

        if(v==S) {
            Intent I = new Intent(this, Result.class);
            I.putExtra("name", Res);
            startActivity(I);
        }
        if(v==Btn){finish();}
    }*/


}
