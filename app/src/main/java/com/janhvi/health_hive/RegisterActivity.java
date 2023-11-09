package com.janhvi.health_hive;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name, password, email, cpassword;
    Button button, button1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.Uname);
        password = findViewById(R.id.Upassword);
        cpassword = findViewById(R.id.Cpassword);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String Password = password.getText().toString();
                String confirmPassword = cpassword.getText().toString();
                String uemail = email.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                if(username.length()==0 || Password.length()==0 || confirmPassword.length()==0 || uemail.length()==0){
                    Toast.makeText(RegisterActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(Password.compareTo(confirmPassword)==0){
                        if(isValid(Password)){
                            db.register(username, uemail, Password);
                            Toast.makeText(RegisterActivity.this, "Record inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Password must be atleast 8 charaters long and must have digits, characters and special symbols", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Password and confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public static boolean isValid(String passwordhere){
        int f1=0,f2=0, f3=0;

        if(passwordhere.length()<8){
            return false;
        }
        else
        {
            for (int i =0; i<passwordhere.length(); i++){
                if(Character.isLetter(passwordhere.charAt(i))){
                    f1=1;
                }
            }

            for (int j =0; j<passwordhere.length(); j++){
                if(Character.isDigit((passwordhere.charAt(j)))){
                    f2=1;
                }
            }

            for (int k =0; k<passwordhere.length(); k++){
                char c = passwordhere.charAt(k);
                if(c>=33&&c<=46 ||c==64){
                    f3=1;
                }
            }

            if(f1==1 &&f2==1 &&f3==1)
                return true;
            return false;

        }
    }
}