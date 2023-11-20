package com.example.ayushmanbhava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText edUsername,edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername=findViewById(R.id.editTextLoginUsername);
        edPassword=findViewById(R.id.editTextLoginPassword);
        btn=findViewById(R.id.buttongoback);
        tv=findViewById(R.id.textView11);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(loginActivity.this,HomeActivity2.class));
                String  username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"ayushmanbhava",null,1);
                if (username.length() == 0 || password.length() == 0) {

                    Toast.makeText(getApplicationContext(), "Please fill the details", Toast.LENGTH_SHORT).show();

                } else {
                    if(db.login(username,password)==1) {

                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();


                        startActivity(new Intent(loginActivity.this,HomeActivity2.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Invalid user name and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this,RegisterActivity2.class));

            }
        });


    }
}