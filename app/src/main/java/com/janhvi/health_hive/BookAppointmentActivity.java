package com.janhvi.health_hive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    TextView textView;
    ImageView imageView;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    private Button timeButton;
    private Button dateButton;
    private Button bookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        ed1 = findViewById(R.id.Fname);
        ed2 =findViewById(R.id.Address);
        ed3 = findViewById(R.id.Cnumber);
        ed4 = findViewById(R.id.fees);
        imageView = findViewById(R.id.back);
        textView = findViewById(R.id.textView2);

        timeButton = findViewById(R.id.buttonAppDate);
        dateButton = findViewById(R.id.buttonAppTime);
        bookButton = findViewById(R.id.buttonbook);


        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(BookAppointmentActivity.this, DoctorDetailsActivity.class);
                startActivity(k);
            }
        });

        Intent z = getIntent();
        String title = z.getStringExtra("text1");
        String fullname = z.getStringExtra("text2");
        String address = z.getStringExtra("text3");
        String contact = z.getStringExtra("text4");
        String fees = z.getStringExtra("text5");


        textView.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Consultation Fees" + fees +"/-");


    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                dateButton.setText(dayOfMonth +"/"+ month+"/"+year);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis()+86400000);

    }



    private void initTimePicker(){


        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeButton.setText(hourOfDay+":"+ minute);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int hourofDay = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this,style,timeSetListener, hourofDay, minute, true);

    }
}