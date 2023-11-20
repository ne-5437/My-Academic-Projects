package com.example.ayushmanbhava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class doctordetailsActivity2 extends AppCompatActivity {
    private String[][] doctor_detail1=
            {
                    {"Doctor Name:ajit","Hospital address:pimpri","exp:5yrs","mobile no:8121806694","400"},
                    {"Doctor Name:varun","Hospital address:hyderabad","exp:9yrs","mobile no:8121806698","700"},
                    {"Doctor Name:keerthi","Hospital address:siripuram","exp:15yrs","mobile no:8121206694","480"},
                    {"Doctor Name:harshini","Hospital address:golconda","exp:8yrs","mobile no:8121896694","900"},
                    {"Doctor Name:vaishnavi","Hospital address:ameerpet","exp:67yrs","mobile no:9121806694","700"}
            };
    private String[][] doctor_detail2=
            {
                    {"Doctor Name:jasmin","Hospital address:punjab","exp:3yrs","mobile no:8191806694","600"},
                    {"Doctor Name:varunteja","Hospital address:akrnataka","exp:9yrs","mobile no:8121306698","730"},
                    {"Doctor Name:suresh","Hospital address:palampur","exp:25yrs","mobile no:9878796542","780"},
                    {"Doctor Name:kavya","Hospital address:golakpur","exp:18yrs","mobile no:8122456222","930"},
                    {"Doctor Name:meera","Hospital address:andhra","exp:7yrs","mobile no:9122806694","770"}
            };
    private String[][] doctor_detail3=
            {
                    {"Doctor Name:meeru","Hospital address:pradhan","exp:56yrs","mobile no:8121234694","494"},
                    {"Doctor Name:valmiki","Hospital address:delhi","exp:19yrs","mobile no:7121806698","790"},
                    {"Doctor Name:bhupathi","Hospital address:kerela","exp:95yrs","mobile no:8121106694","413"},
                    {"Doctor Name:himai","Hospital address:ramapur","exp:18yrs","mobile no:8121096694","999"},
                    {"Doctor Name:sathwika","Hospital address:merpet","exp:6yrs","mobile no:9111806694","700"}
            };
    private String[][] doctor_detail4=
            {
                    {"Doctor Name:ganguli","Hospital address:gangotri","exp:34yrs","mobile no:5121806694","493"},
                    {"Doctor Name:venugopal","Hospital address:hamipur","exp:9yrs","mobile no:9658066982","760"},
                    {"Doctor Name:vamshika","Hospital address:sheikpuram","exp:15yrs","mobile no:8123456625","481"},
                    {"Doctor Name:sundari","Hospital address:grampur","exp:46yrs","mobile no:4121896694","980"},
                    {"Doctor Name:lathjivi","Hospital address:lakpuret","exp:6yrs","mobile no:9191806694","760"}
            };
    private String[][] doctor_detail5=
            {
                    {"Doctor Name:giri","Hospital address:hushpur","exp:45yrs","mobile no:1121806694","489"},
                    {"Doctor Name:chearni","Hospital address:madhapur","exp:20yrs","mobile no:8121820698","778"},
                    {"Doctor Name:kyathi","Hospital address:dolakpur","exp:24yrs","mobile no:2121206694","490"},
                    {"Doctor Name:meenakshi","Hospital address:chennai","exp:4yrs","mobile no:3121896694","980"},
                    {"Doctor Name:vemula","Hospital address:borabanda","exp:7yrs","mobile no:8121846694","760"}
            };
    TextView tv;
    String [][] doctor_details={};
    Button btn;
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctordetails2);
        tv=findViewById(R.id.TextViewldpackage);
        btn=findViewById(R.id.buttonldgotocart);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("family Physician")==0)
            doctor_details=doctor_detail1;
        else
        if(title.compareTo("diecitian")==0)
            doctor_details=doctor_detail2;
        else
        if(title.compareTo("dentist")==0)
            doctor_details=doctor_detail3;
        else
        if(title.compareTo("surgeaon")==0)
            doctor_details=doctor_detail4;
        else

            doctor_details=doctor_detail5;





       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(doctordetailsActivity2.this,FInddoctorActivity2.class));
           }
       });
        list = new ArrayList<>();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "cons fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.EditTextViewld);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(doctordetailsActivity2.this, bookappoActivity2.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }

        });
    }


}