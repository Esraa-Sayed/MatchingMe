package com.example.log_in.CmplexExpr;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.log_in.R;

public class angry_happiness extends AppCompatActivity {
ImageView ImageExpr;
TextView TextExpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2_expr);
        ImageExpr = findViewById(R.id.ImageExpr);
        TextExpr = findViewById(R.id.TextExpr);

        ImageExpr.setImageResource(R.drawable.angry_happiness);
        TextExpr.setText(R.string.angry_happinessDes);
    }
}