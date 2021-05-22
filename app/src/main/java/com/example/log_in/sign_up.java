package com.example.log_in;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.log_in.DP.SQL;
import com.example.log_in.DP.dataBaseAdapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sign_up extends AppCompatActivity implements View.OnClickListener {
    ImageButton IB;
    EditText Name,EmailAddress,Password;
    Button button;
    RadioGroup G;
    CheckBox CB;
    Bitmap B;
    Uri S;
    String Error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        IB = findViewById(R.id.imageButton);
        Name = findViewById(R.id.PersonName);
        EmailAddress = findViewById(R.id.EmailAddress2);
        G = findViewById(R.id.RG);
        CB=findViewById(R.id.checkBox);
        Password= findViewById(R.id.Password3);
        button = findViewById(R.id.button3);
        button.setOnClickListener(this);
        if (savedInstanceState != null) {
            B = (Bitmap) savedInstanceState.getParcelable("B");
            if(B!=null) {
                IB.setImageBitmap(B);

            }
        }
        registerForContextMenu(IB);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main2,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.TakePhoto :
                Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(i.resolveActivity(getPackageManager())!=null)
                {
                    startActivityForResult(i,10);
                }
                else Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                break;
            case R.id.Gallery :
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(pickPhoto.resolveActivity(getPackageManager())!=null) {
                    startActivityForResult(pickPhoto, 1);
                }
                else Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&data!=null)
        {
            switch(requestCode) {
                case 10:
                    B = (Bitmap) data.getExtras().get("data");
                    IB.setImageBitmap(B);

                    break;
                case 1:
                    S=data.getData();
                    try {
                        B = MediaStore.Images.Media.getBitmap(this.getContentResolver(), S);
                        IB.setImageBitmap(B);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }

    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public static boolean ValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    @Override
    public void onClick(View v) {
        if(v==button)
        {
            Error="";
            if(Name.getText().toString().isEmpty())
                Error+=" Name can't be empty \n";
            if (!isEmailValid(EmailAddress.getText().toString()))
                 Error+= " Invalid email \n";

            if( Password.getText().toString().length()<8 || !ValidPassword( Password.getText().toString()))
                Error+= " Invalid passward \n";

            int radioId = G.getCheckedRadioButtonId();
            if(radioId == -1) {
                Error += " Must choose your gender \n";
            }
            if(!CB.isChecked())Error+=" Must Accepted privacy policy \n";
            if(Error.isEmpty())
            {
                String Gender = "";
                SQL entry;
                long check = -1;
                if(R.id.radioButton == radioId ) Gender = "Male";
                else Gender = "Female";

                dataBaseAdapter adapter = new dataBaseAdapter(this);
                if(B!=null) {
                    entry = new SQL(EmailAddress.getText().toString(), Name.getText().toString(), Gender, Password.getText().toString(), B);
                    check = adapter.addEntry(entry);
                }
                else
                {
                    entry = new SQL(EmailAddress.getText().toString(), Name.getText().toString(), Gender, Password.getText().toString());
                    check = adapter.addEntry(entry);
                }

                    if (check < 0) {
                        Toast.makeText(this, "The email already  ", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(this, "Registration done successfully", Toast.LENGTH_LONG).show();
                        Intent I = new Intent();
                        I.putExtra("Email", EmailAddress.getText().toString());
                        I.putExtra("passward", Password.getText().toString());
                        setResult(RESULT_OK, I);
                        finish();
                    }
            }
            else Toast.makeText(this,Error,Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(B!=null)
        outState.putParcelable("B", B);
    }

}