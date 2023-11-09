package com.janhvi.health_hive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        ed1 = findViewById(R.id.Fname);
        ed2 = findViewById(R.id.address);
        ed3 = findViewById(R.id.PinCode);
        ed4 = findViewById(R.id.mobileNumber);

        btn = findViewById(R.id.buttonAABack);


        Intent intent = getIntent();

        String [] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("Date");
        String time = intent.getStringExtra("Time");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username, ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(), ed4.getText().toString(), date, time, 273212, Float.parseFloat(price[1]));
                db.removeCart(username, "lab");
                Toast.makeText(LabTestBookActivity.this, "your Booking is done successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class ));
            }
        });
    }
}