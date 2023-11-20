package com.example.ayushmanbhava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabtestMainActivity2 extends AppCompatActivity {
    private String[][] Packages=

    {


        {"package 1: full body checkup","","","","788"},
        {"package 2: blood glucode fasting","","","","238"},
        {"package 3: covid-19 checkup","","","","728"},
        {"package 4: thyriod checkup","","","","988"},
            {"package 5: immunity checkup","","","","688"}

    };
    private String[] Package_details={
            "blood glusose fasting\n"+
                    "completer hemogran\n"+
                    "Hbalc\n",
                    "iron studies\n"+
                    "kidney function\n",
                    "LDH\n"+
                    "liver functio\n",
                    "blood gunc",
            "hpetsone fucntion",
                    "urine function\n"+
                    "lipid profile\n" +
                    "CRP"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btngotocart,btnback;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtest_main2);
        btngotocart=findViewById(R.id.buttonltgotocart);
        btnback=findViewById(R.id.buttonldgotocart);
        listView=findViewById(R.id.EditTextViewld);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabtestMainActivity2.this,HomeActivity2.class));
            }
        });
        list=new ArrayList();
        for(int i=0;i<Packages.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",Packages[i][0]);
            item.put("line2",Packages[i][1]);
            item.put("line3",Packages[i][2]);
            item.put("line4",Packages[i][3]);
            item.put("line5","total cost"+Packages[i][4]+"/-");
            list.add(item);

        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(LabtestMainActivity2.this,LabtestdetailsActivity2.class);
                it.putExtra("text1",Packages[i][0]);
                it.putExtra("text2",Package_details[i]);
                it.putExtra("text3",Packages[i][4]);
                startActivity(it);

            }
        });


    }
}