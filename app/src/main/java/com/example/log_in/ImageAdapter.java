package com.example.log_in;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<Images> {
private Context context;
private int mResource;
    public ImageAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Images> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(mResource,parent,false);
        ImageView Image1 = convertView.findViewById(R.id.image1);
        ImageView Image2 = convertView.findViewById(R.id.image2);
        Image1.setImageResource(getItem(position).getImage1());
        Image2.setImageResource(getItem(position).getImage2());



        return convertView;
    }
}
