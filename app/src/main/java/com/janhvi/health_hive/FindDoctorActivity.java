package com.janhvi.health_hive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });

        CardView familyphysician = findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                k.putExtra("title","Family Physician");
                startActivity(k);
            }
        });

        CardView dietician = findViewById(R.id.cardFDBuyMedidicine);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                k.putExtra("title","Dietician");
                startActivity(k);
            }
        });


        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                k.putExtra("title","Dentist");
                startActivity(k);
            }
        });


        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                k.putExtra("title","Surgeon");
                startActivity(k);
            }
        });


        CardView cardiologist = findViewById(R.id.cardFDCardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                k.putExtra("title","Cardiologist");
                startActivity(k);
            }
        });

    }
}