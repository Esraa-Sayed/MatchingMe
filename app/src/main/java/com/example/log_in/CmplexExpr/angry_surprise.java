package com.example.log_in.CmplexExpr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.log_in.R;

public class angry_surprise extends AppCompatActivity {
ImageView ImageExpr;
TextView TextExpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2_expr);
        ImageExpr = findViewById(R.id.ImageExpr);
        TextExpr = findViewById(R.id.TextExpr);

        ImageExpr.setImageResource(R.drawable.angry_surprise);
        TextExpr.setText(R.string.angry_surpriseDes);
    }
}