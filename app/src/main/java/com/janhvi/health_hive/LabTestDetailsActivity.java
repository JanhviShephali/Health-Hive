package com.janhvi.health_hive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackagename, tvTotalCost;
    EditText edDetails;
    Button btnback, BtnAddToCart;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);


        tvPackagename = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.editTextTextMultiLine);
        btnback = findViewById(R.id.buttonLDBack);
        BtnAddToCart = findViewById(R.id.buttonLDAddToCart);




        Intent intent = new Intent();
        tvPackagename.setText(intent.getStringExtra("text1"));
        tvTotalCost.setText(intent.getStringExtra("text2"));
        edDetails.setText("Total Cost:" + intent.getStringExtra("text1") + "/-");


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        BtnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username  = sharedPreferences.getString("username", "").toString();
                String Product = tvPackagename.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(),"healtcare", null, 1);

                if(db.checkCart(username, Product)==1){
                    Toast.makeText(LabTestDetailsActivity.this, "Item already added", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addCart(username, Product, price,"lab");
                    Toast.makeText(LabTestDetailsActivity.this, "Record Insertted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }

            }
        });
    }
}