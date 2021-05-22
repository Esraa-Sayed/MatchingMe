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

public class Sad extends AppCompatActivity {
    VideoView sadV;
    ListView imagessad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sad);
        sadV = findViewById(R.id.sadV);
        imagessad = findViewById(R.id.imagessad);
        String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.sad;
        Uri uri = Uri.parse(VideoPath);
        sadV.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        sadV.setMediaController(mediaController);
        mediaController.setAnchorView(sadV);
        ArrayList<Images> Images = new ArrayList<>();
        Images.add(new Images(R.drawable.sad,R.drawable.sad2));
        Images.add(new Images(R.drawable.sad3,R.drawable.sad4));
        Images.add(new Images(R.drawable.sad5,R.drawable.sad6));
        Images.add(new Images(R.drawable.sad_cartoon,R.drawable.sad_cartoon3));
        ImageAdapter imageAdapter = new ImageAdapter(this,R.layout.images_list,Images);
        imagessad.setAdapter(imageAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        sadV.start();
    }
}