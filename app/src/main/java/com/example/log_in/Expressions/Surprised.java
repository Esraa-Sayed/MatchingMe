package com.example.log_in.Expressions;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.log_in.ImageAdapter;
import com.example.log_in.Images;
import com.example.log_in.R;

import java.util.ArrayList;

public class Surprised extends AppCompatActivity {
    VideoView SurprisedV;
    ListView imagesSurprised;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surprised);
        SurprisedV = findViewById(R.id.SurprisedV);
        imagesSurprised = findViewById(R.id.imagesSurprised);
        String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.mondahsh;
        Uri uri = Uri.parse(VideoPath);
        SurprisedV.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        SurprisedV.setMediaController(mediaController);
        mediaController.setAnchorView(SurprisedV);
        ArrayList<Images> Images = new ArrayList<>();
        Images.add(new Images(R.drawable.surprise,R.drawable.surprise2));
        Images.add(new Images(R.drawable.surprise3,R.drawable.surprise4));
        Images.add(new Images(R.drawable.surprise5,R.drawable.surprise6));
        ImageAdapter imageAdapter = new ImageAdapter(this,R.layout.images_list,Images);
        imagesSurprised.setAdapter(imageAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        SurprisedV.start();
    }
}