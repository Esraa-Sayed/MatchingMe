package com.example.log_in;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.log_in.DP.SQL;
import com.example.log_in.DP.dataBaseAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText E, E2;
    Button B2, B1;
    String Error;
    int ID = -1;
    String Email;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        E = findViewById(R.id.editTextTextEmailAddress);
        E2 = findViewById(R.id.editTextTextPassword);
        B2 = findViewById(R.id.button2);
        B1 = findViewById(R.id.button);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
        pref = getSharedPreferences("Email Saved", MODE_PRIVATE);
        Email = pref.getString("Email", "fail");
        if (!Email.equals("logOut") && !Email.equals("fail")) {
            dataBaseAdapter adapter = new dataBaseAdapter(this);
            ID = adapter.getEntryByID(Email);

            Intent I = new Intent(this, splashScrean.class);
            I.putExtra("ID", ID);
            startActivity(I);
            finish();
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20 && resultCode == RESULT_OK && data != null) {
            String Email = data.getExtras().getString("Email");
            String passward = data.getExtras().getString("passward");
            E.setText(Email);
            E2.setText(passward);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == B2) {
            Error = "";
            if (!isEmailValid(E.getText().toString()))
                Error += " Invalid email \n";

            if (E2.getText().toString().length() < 8 || !ValidPassword(E2.getText().toString()))
                Error += " Invalid passward ";
            if (!Error.isEmpty()) Toast.makeText(this, Error, Toast.LENGTH_LONG).show();
            else {
                SQL entry = new SQL("", "", "", "");
                dataBaseAdapter adapter = new dataBaseAdapter(this);
                 ID = adapter.getEntryByID(E.getText().toString());
                Log.e("TAG", ""+ID);
                if (ID != -1) {
                    entry = adapter.getEntry(ID);
                    if (!entry.getPassward().equals(E2.getText().toString())) {
                        Toast.makeText(this, "Error passward", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent I = new Intent(this, home.class);
                        I.putExtra("ID", ID);
                        startActivity(I);
                        finish();
                    }
                }
                else
                    Toast.makeText(this, "Email Not Exist", Toast.LENGTH_LONG).show();


            }
        }
        if (v == B1) {
            Intent I = new Intent(this, sign_up.class);
            startActivityForResult(I, 20);
        }
    }
}
