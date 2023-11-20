package com.example.ayushmanbhava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabtestdetailsActivity2 extends AppCompatActivity {
    TextView tvPackageName,tvTotalcost;
    EditText eddetails;
    Button btnaddcart,btnback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtestdetails2);
        tvPackageName=findViewById(R.id.TextViewldpackage);
        tvTotalcost=findViewById(R.id.textViewlbcost);
        eddetails=findViewById(R.id.EditTextViewld);
        btnaddcart=findViewById(R.id.buttonldgotocart);
        btnback=findViewById(R.id.buttonldback);
        eddetails.setKeyListener(null);
        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        eddetails.setText("total cost:,"+intent.getStringExtra("text3")+"/-");
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", " ").toString();
                String product=tvPackageName.getText().toString();
                float price=Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db=new Database(getApplicationContext(),"ayushmanbhava",null,1);
                if(db.checkcart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "product already added " , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(), "record inseted " , Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabtestdetailsActivity2.this,LabtestMainActivity2.class));
                }

            }
        });

    }
}