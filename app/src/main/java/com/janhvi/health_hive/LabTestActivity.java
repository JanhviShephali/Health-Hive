package com.janhvi.health_hive;

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

public class LabTestActivity extends AppCompatActivity {

    private String packages [][]  ={
            {"Pacakge 1 : Full Body Checkup", "","","","999"},
            {"pacakge 2 : Blood GLucose fastening", "","","","299"},
            {"pacakge 3 : Covid-19 AntiBody", "","","","899"},
            {"pacakge 4 : Thyroid Check", "","","","499"},
            {"pacakge 5 : Immunity Check", "","","","699"}
    };


    private String [] package_details ={
            "Blood pressure test",
            "Blood sugar test",
            "Cholesterol test",
            "Hemoglobin test",
            "Kidney function test",
            "Liver function test",
            "Thyroid function test",
            "Complete blood count (CBC)",
            "Electrocardiogram (ECG)",
            "Lung function test",
            "Urine analysis",
            "Stool analysis",
            "Pregnancy test",
            "HIV test",
            "Rheumatoid factor test",
            "Prostate-specific antigen test (PSA)",
            "Tumor marker test",
            "Erythrocyte sedimentation rate (ESR)",
            "C-reactive protein (CRP) test",
            "Immunoglobulin test (Ig)"

    };

    ArrayList arrayList;
    SimpleAdapter simpleAdapter;
    HashMap<String,String> item;
    Button GotoCart, backButton;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        backButton = findViewById(R.id.buttonDDBack);
        GotoCart = findViewById(R.id.buttonDDCart);
        listView = findViewById(R.id.listViewDD);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        arrayList = new ArrayList();
        for(int i =0; i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: " +packages[i][4]+ "/-");
            arrayList.add(item);

        }

        simpleAdapter = new SimpleAdapter(this, arrayList,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "lin3", "lin4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent k = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                k.putExtra("text1", packages[i][0]);
                k.putExtra("text2", package_details[i]);
                k.putExtra("text3", packages[i][4]);
                startActivity(k);
            }
        });

        GotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });
    }
}