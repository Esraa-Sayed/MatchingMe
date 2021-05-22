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

public class Confusion extends AppCompatActivity {
    VideoView confusionV;
    ListView imagesconfusion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confusion);
        confusionV = findViewById(R.id.confusionV);
        imagesconfusion = findViewById(R.id.imagesconfusion);
        String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.confusion;
        Uri uri = Uri.parse(VideoPath);
        confusionV.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        confusionV.setMediaController(mediaController);
        mediaController.setAnchorView(confusionV);
        ArrayList<Images> Images = new ArrayList<>();
        Images.add(new Images(R.drawable.haqer,R.drawable.haqer2));
        Images.add(new Images(R.drawable.haqer3,R.drawable.haqer_cartoon));
        ImageAdapter imageAdapter = new ImageAdapter(this,R.layout.images_list,Images);
        imagesconfusion.setAdapter(imageAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        confusionV.start();
    }
}