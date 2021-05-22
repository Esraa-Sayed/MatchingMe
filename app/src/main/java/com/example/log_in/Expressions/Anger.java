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

public class Anger extends AppCompatActivity {
    VideoView angerV;
    ListView imagesanger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anger);
        angerV = findViewById(R.id.angerV);
        imagesanger = findViewById(R.id.imagesanger);
        String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.angry;
        Uri uri = Uri.parse(VideoPath);
        angerV.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        angerV.setMediaController(mediaController);
        mediaController.setAnchorView(angerV);
        ArrayList<Images> Images = new ArrayList<>();
        Images.add(new Images(R.drawable.anger,R.drawable.angery2));
        Images.add(new Images(R.drawable.anger4,R.drawable.anger3));
        Images.add(new Images(R.drawable.angercartoones,R.drawable.anger_carton3));
        ImageAdapter imageAdapter = new ImageAdapter(this,R.layout.images_list,Images);
        imagesanger.setAdapter(imageAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        angerV.start();
    }
}