package com.example.log_in.Expressions;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.log_in.ImageAdapter;
import com.example.log_in.Images;
import com.example.log_in.R;

import java.util.ArrayList;

public class Smile extends AppCompatActivity {
VideoView SmileV;
ListView imagesSmile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smile);
        SmileV = findViewById(R.id.SmileV);
        imagesSmile = findViewById(R.id.imagesSmile);
        String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.mobtaseem;
        Uri uri = Uri.parse(VideoPath);
        SmileV.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        SmileV.setMediaController(mediaController);
        mediaController.setAnchorView(SmileV);
        ArrayList<Images> Images = new ArrayList<>();
        Images.add(new Images(R.drawable.smile,R.drawable.smile2));
        Images.add(new Images(R.drawable.smile3,R.drawable.smile4));
        Images.add(new Images(R.drawable.smile5,R.drawable.smile6));
        ImageAdapter imageAdapter = new ImageAdapter(this,R.layout.images_list,Images);
        imagesSmile.setAdapter(imageAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SmileV.start();
    }
}