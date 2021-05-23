package com.example.log_in;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import com.example.log_in.DP.SQL;
import com.example.log_in.DP.dataBaseAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class home extends AppCompatActivity implements View.OnClickListener {
    Button courses;
    Button Exam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        courses = findViewById(R.id.courses);
        Exam = findViewById(R.id.Exam);
        courses.setOnClickListener(this);
        Exam.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == courses)
        {
            Intent i = new Intent(this,ChooseLevel.class);
            startActivity(i);
        }
        if(view == Exam)
        {
            Intent i = new Intent(this,ChooseExamLevel.class);
            startActivity(i);
        }
    }
}