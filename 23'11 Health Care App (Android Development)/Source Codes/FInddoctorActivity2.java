package com.example.ayushmanbhava;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;

public class FInddoctorActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctor2);


CardView exit=findViewById(R.id.CardLabgoback);
exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(FInddoctorActivity2.this, HomeActivity2.class));

    }
});
CardView familyphyscian=findViewById(R.id.CardLabFDfamiliyphysician);
familyphyscian.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent it=new Intent(FInddoctorActivity2.this, doctordetailsActivity2.class);
        it.putExtra("title","family physcian");
        startActivity(it);

    }
});
        CardView dietician=findViewById(R.id.CardLabFDdietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FInddoctorActivity2.this, doctordetailsActivity2.class);
                it.putExtra("title","deitcian");
                startActivity(it);

            }
        });
        CardView dentist=findViewById(R.id.CardLabFDfamiliydentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FInddoctorActivity2.this, doctordetailsActivity2.class);
                it.putExtra("title","dentist");
                startActivity(it);

            }
        });
        CardView surgeon=findViewById(R.id.CardLabFDfamiliysurgeaon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FInddoctorActivity2.this, doctordetailsActivity2.class);
                it.putExtra("title","surgeon");
                startActivity(it);

            }
        });
        CardView cardiologist=findViewById(R.id.CardLabFDfamilycardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FInddoctorActivity2.this, doctordetailsActivity2.class);
                it.putExtra("title","cardiologist");
                startActivity(it);

            }
        });

    }
}