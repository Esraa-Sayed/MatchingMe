package com.example.log_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.log_in.DP.SQL;
import com.example.log_in.DP.dataBaseAdapter;

public class splashScrean extends AppCompatActivity {
    TextView NameOFUser;
    ImageView UserImage;
    private SQL entry;
    private int ID;
    private dataBaseAdapter adapter;
    private Bitmap B;
    private SharedPreferences pref;
    Runnable runnable = null;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screan);
        NameOFUser = findViewById(R.id.Name);
        UserImage = findViewById(R.id.imageView2);
        Intent I = getIntent();
        ID = I.getExtras().getInt("ID");
        adapter = new dataBaseAdapter(this);
        entry = adapter.getEntry(ID);
        B = entry.getB();
        /*if (B != null) {
            UserImage.setImageBitmap(entry.getB());
        } else {
            Drawable draw = getResources().getDrawable(android.R.drawable.ic_menu_gallery);
           // UserImage.setImageDrawable(draw);
        }*/
       // NameOFUser.setText("Hi , " + entry.getName() + " welcome to our app");
        if(savedInstanceState == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    synchronized (this) {
                        try {
                            wait(2000);
                            I();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        thread.interrupt();
    }

    void I() {
        Intent I = new Intent(this, home.class);
        I.putExtra("ID", ID);
        startActivity(I);
        finish();
    }
}
