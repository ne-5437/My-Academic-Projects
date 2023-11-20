package com.example.ayushmanbhava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.slider.LabelFormatter;

public class HomeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        SharedPreferences sharedPreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
        String Username = sharedPreferences.getString("username", " ").toString();
        Toast.makeText(getApplicationContext(), "Welcome " + Username, Toast.LENGTH_SHORT).show();

        CardView exit=findViewById(R.id.Cardexit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity2.this, loginActivity.class));
            }

        });
        CardView findDoctor=findViewById(R.id.Cardfinddoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity2.this, FInddoctorActivity2.class));

            }
        });
        CardView Labtest=findViewById(R.id.CardLabTest);
        Labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity2.this, LabtestMainActivity2.class));

            }
        });
    }
}