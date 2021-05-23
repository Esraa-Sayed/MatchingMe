package com.example.log_in.CmplexExpr;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.log_in.R;

public class fear_happy extends AppCompatActivity {
ImageView ImageExpr;
TextView TextExpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level2_expr);
        ImageExpr = findViewById(R.id.ImageExpr);
        TextExpr = findViewById(R.id.TextExpr);

        ImageExpr.setImageResource(R.drawable.fear_happy);
        TextExpr.setText(R.string.fear_happyDes);
    }
}