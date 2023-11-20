package com.example.ayushmanbhava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity2 extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        edUsername = findViewById(R.id.editTextAppaddress);
        edPassword = findViewById(R.id.editTextAppcontact);
        edEmail = findViewById(R.id.editTextAppfullname1);
        edConfirm = findViewById(R.id.editTextAppconfsfee);
        btn = findViewById(R.id.buttongoback);
        tv = findViewById(R.id.textView11);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity2.this, loginActivity.class));

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(), "ayushmanbhava", null, 1);

                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "please fill the details", Toast.LENGTH_SHORT).show();
                } else {
                    if(password.compareTo(confirm)==0) {
                        if(isValid(password)){
                            db.register(username,email,password);
                        Toast.makeText(getApplicationContext(), "record inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity2.this, loginActivity.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "password must contain alteat 8 charcters", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }


    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) ;
                f1 = 1;
            }
        }
        for (int r = 0; r < passwordhere.length(); r++) {
            if (Character.isDigit(passwordhere.charAt(r))) ;
            f2 = 1;
        }

        for (int s = 0; s < passwordhere.length(); s++) {
            char c = passwordhere.charAt(s);
            if (c >= 33 && c <= 46 || c == 64) {
                f3 = 1;
            }
        }
        if (f1 == 1 && f2 == 1 && f3 == 1)
            return true;
        return false;
    }
}

