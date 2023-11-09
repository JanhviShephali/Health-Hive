package com.janhvi.health_hive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String [][] doctor_details1 ={
            { "Doctor Name: Dr. S C Vaish, Hospital: Apollo Clinic Gorakhpur, Experience: 10 years, Mobile Number:  0551-2335800, Fee: 400"},
            {"Doctor Name: Dr. Shipra, Hospital: Apollo Clinic Gorakhpur, Experience: 15 years, Mobile Number:  0551-2335800, Fee: 600"},
            {"Doctor Name: Dr. Vishal Srivastav, Hospital: Apollo Clinic Gorakhpur, Experience: 5 years, Mobile Number:  0551-2335800, Fee: $500"},
            {"Doctor Name: Dr. Abhishek Seth, Hospital: M.M.Nurshing Home , Experience: 11 years, Mobile Number: 011 4084 5776  , Fee: 500"},
            {"Doctor Name: Dr. Dr. Gaurav Pandey, Hospital:  Medicity Hosptial, Experience: 5 years, Mobile Number: 07947287619, Fee: 400", }
    };

    private String [][] doctor_details2 ={
            {"Doctor Name: Dr. Aashashri Upadhya, Hospital: Shimoga - Sahyadri Narayana Multispeciality, Experience: 5 years, Mobile Number: 08067506856, Fee: 500"},
            {"Doctor Name: Dr. Emmany D R, Hospital:  Mazumdar Shaw Medical Center, Experience: 8 years, Mobile Number: 08067506836, Fee: 600"},
            {"Doctor Name: Dr. Priya Dwivedi, Hospital:Brahmananda Narayana Multispeciality, Experience: 8 years, Mobile Number: 0806706847, Fee: 500"},
            {"Doctor Name: Dr. Suparna Mukherjee, Hospital:  Narayana Institute of Cardiac Sciences, Experience: 9 years, Mobile Number: 08067506836, Fee: 800"},
            {"Doctor Name: Dr. Nishitha Krishnan T, Hospital: Narayana Medical Centre, Experience: 9 years, Mobile Number: 08067506836, Fee: 700",}
    };

    private String [][] doctor_details3 ={
            {"Doctor Name: Dr. Shabana Fatima, Hospital: Fatima, Experience: 6 years, Mobile Number: 8005421664, Fee: 500"},
            {"Doctor Name: Dr. Anurag Srivastava , Hospital: Family Dental Clinic, Experience: 14 years, Mobile Number: 07947464150, Fee: 500"},
            {"Doctor Name: Dr. Garima Srivastava, Hospital: Family Dental Clinic, Experience: 8 years, Mobile Number: 07947464150, Fee: 500"},
            {"Doctor Name: Dr. Srijan Kumar Srivastav, Hospital: S K Dentals, Experience: 9 years, Mobile Number: 07947470121, Fee: 600"},
            {"Doctor Name: Dr. Dr. Himanshu Mani Tripathi, Hospital: Saraswati Dental Clinic, Experience: 10 years, Mobile Number: 07947352915, Fee: 5000",}
    };

    private String [][] doctor_details4 ={
            {"Doctor Name: Dr. Jai Prakash Jaiswal, Hospital: Life Care, Experience: 46 years, Mobile Number: 11408 48840, Fee: 500"},
            {"Doctor Name: Dr. Dr. Agraj Mishra, Hospital: Pragti Hospital, Experience: 10 years, Mobile Number: 011 4116 9399, Fee: 500"},
            {"Doctor Name: Dr. Dr. Aman Agarwal, Hospital: Garg Hospital, Experience: 11 years, Mobile Number: 05512345853, Fee: 600"},
            {"Doctor Name: Dr. Dr. Binay Kumar Shukla, Hospital: Garg Hospital, Experience: 15 years, Mobile Number: 05512345853, Fee: 300"},
            {"Doctor Name: Dr. Dr. Parveen Singh, Hospital: Adhira hospital, Experience: 14 years, Mobile Number: 011 4084 4823, Fee: 400" }
    };


    private String [][] doctor_details5 ={
            {"Doctor Name : Dr. Prakash Chand Shahi", "Hospital Address : Pulse Heart Center", "Experience : 24years", "Mobile Number : 919455899378 ", "Fees : 800" },
            {"Doctor Name : Dr. Deepak Verma", "Hospital Address :  Jeevandeep Heart Care Centre", "Experience : 12years", "Mobile Number : 9336708650 ", "Fees : 700" },
            {"Doctor Name : Dr. K K Mishra", "Hospital Address : Aastha Cardiac Clinic", "Experience : 35years", "Mobile Number : 9935294218 ", "Fees : 700" },
            {"Doctor Name : Dr. Akhilesh Kumar Patel", "Hospital Address : Abhigya Heart Care Center", "Experience : 6years", "Mobile Number : 7081802009 ", "Fees : 800" },
            {"Doctor Name : Dr. Munish Narain Gupta", "Hospital Address : Gupta Heart And Medical Centre", "Experience : 5years", "Mobile Number : 8019588000", "Fees : 800" }
    };



    TextView tv;
    Button btn;
    String [][] doctor_details ={};
    ArrayList arrayList;
    SimpleAdapter simpleAdapter;
    HashMap<String, String > item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv= findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        getGeo();
        Intent k = getIntent();
        String title = k.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0){
            doctor_details = doctor_details1;
        }
        else if(title.compareTo("Dietician")==0){
            doctor_details=doctor_details2;
        }
        else if(title.compareTo("Surgeon")==0){
            doctor_details=doctor_details3;
        }
        else if(title.compareTo("Dentist")==0){
            doctor_details=doctor_details4;
        }
        else{
            doctor_details=doctor_details5;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        arrayList = new ArrayList<>();
        for(int i =0; i<doctor_details.length; i++){
            item = new HashMap<String, String >();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Consulataion Fees: " +doctor_details[i][4] +"/-");
            arrayList.add(item);
        }

        simpleAdapter = new SimpleAdapter(this,arrayList,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e }
        );

        ListView listView = findViewById(R.id.listViewDD);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent k = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                k.putExtra("text1", title);
                k.putExtra("text2", doctor_details[i][0]);
                k.putExtra("text3", doctor_details[i][1]);
                k.putExtra("text4", doctor_details[i][3]);
                k.putExtra("text5", doctor_details[i][4]);
                startActivity(k);
            }
        });

    }

    private void getGeo() {

        String location = "geo:0,0?q= Paitent+Doctor";
        Uri gmmIntentUri = Uri.parse(location);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        Log.e("map", ""+mapIntent.getData());
        startActivity(mapIntent);
    }
}