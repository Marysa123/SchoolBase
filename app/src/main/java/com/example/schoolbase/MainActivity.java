package com.example.schoolbase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button btnSignIn,btnSignUp;
    DBHelper myDB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

        btnSignUp = (Button) findViewById(R.id.register_button);
        btnSignIn = (Button) findViewById(R.id.login_button);

        myDB = new DBHelper(this);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("")|| pass.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter the Credentials.", Toast.LENGTH_SHORT).show();
                }
                else{
                   Boolean result = myDB.checkusernamePassword(user,pass);
                    if (result==true){
                        Intent intent = new Intent(getApplicationContext(),MainPageApplication.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid Crediantials.", Toast.LENGTH_SHORT).show();
                    }

                }



            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this,"Fill all the fields.",Toast.LENGTH_SHORT).show();

                }
                else{
                   Boolean resultcheckUser = myDB.checkusername(user);
                   if (resultcheckUser == false){
                        Boolean regResult = myDB.insertData(user,pass);
                        if (regResult == true){
                            Toast.makeText(MainActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                        }
                   }
                   else{
                       Toast.makeText(MainActivity.this,"User already Exists. \n Please Sign In",Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });



    }

}