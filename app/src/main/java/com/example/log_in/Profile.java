package com.example.log_in;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import com.example.log_in.DP.SQL;
import com.example.log_in.DP.dataBaseAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Profile extends AppCompatActivity{
    private ImageView imageView;
    private String Email;
    private TextView Name, Email_u, Gender;
    private SQL entry;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private dataBaseAdapter adapter;
    private Bitmap B;
    private Uri S;
    private int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Name = findViewById(R.id.textView8);
        Email_u = findViewById(R.id.textView9);
        Gender = findViewById(R.id.textView10);

        Intent I = getIntent();
        ID= I.getExtras().getInt("ID");

        adapter = new dataBaseAdapter(this);
        entry = adapter.getEntry(ID);
        Email = entry.getEmail();
        pref = getSharedPreferences("Email Saved", MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("Email", Email);
        editor.commit();
        Name.setText(entry.getName());
        Email_u.setText(entry.getEmail());
        Gender.setText(entry.getGender());
        B = entry.getB();
        if (B != null) {
            imageView.setImageBitmap(entry.getB());
        } else {
            Drawable draw = getResources().getDrawable(android.R.drawable.ic_menu_gallery);
            imageView.setImageDrawable(draw);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.DeleteA:
                adapter.Delete(ID);
                editor = pref.edit();
                editor.putString("Email", "logOut");
                editor.commit();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.LogOut: {
                editor = pref.edit();
                editor.putString("Email", "logOut");
                editor.commit();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (B != null)
            getMenuInflater().inflate(R.menu.menu_main3, menu);
        else
            getMenuInflater().inflate(R.menu.menu_main2, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.TakePhoto:
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, 50);
                } else Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                break;
            case R.id.Gallery:
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (pickPhoto.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(pickPhoto, 12);
                } else Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                break;
            case R.id.deletePhoto:
                Drawable draw = getResources().getDrawable(android.R.drawable.ic_menu_gallery);
                imageView.setImageDrawable(draw);
                adapter.Delete_image_from_DataBase(ID);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case 50:
                    B = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(B);
                    break;
                case 12:
                    S = data.getData();
                    try {
                        B = MediaStore.Images.Media.getBitmap(this.getContentResolver(), S);
                        imageView.setImageBitmap(B);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            entry.setB(B);
            adapter.change_photo(ID, B);
        }
    }
}
