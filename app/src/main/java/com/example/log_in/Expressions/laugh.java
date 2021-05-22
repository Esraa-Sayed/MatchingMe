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

public class laugh extends AppCompatActivity {
    VideoView laughV;
    ListView imageslaugh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laugh);
        laughV = findViewById(R.id.laughV);
        imageslaugh = findViewById(R.id.imageslaugh);
        String VideoPath = "android.resource://"+getPackageName()+"/"+R.raw.saeed;
        Uri uri = Uri.parse(VideoPath);
        laughV.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        laughV.setMediaController(mediaController);
        mediaController.setAnchorView(laughV);
        ArrayList<Images> Images = new ArrayList<>();
        Images.add(new Images(R.drawable.laugh8,R.drawable.laugh9));
        Images.add(new Images(R.drawable.laugh11,R.drawable.laugh12));
        Images.add(new Images(R.drawable.happy,R.drawable.happy2));
        Images.add(new Images(R.drawable.happy4,R.drawable.laugh10));
        Images.add(new Images(R.drawable.happy_cartoon2,R.drawable.happy_cartoon4));
        ImageAdapter imageAdapter = new ImageAdapter(this,R.layout.images_list,Images);
        imageslaugh.setAdapter(imageAdapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        laughV.start();
    }
}