package com.example.schoolbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolbase.database.DBHandler;

public class addYcheniki extends AppCompatActivity {

    TextView txtFio,txtDataRos,txtClass,txtIntelect,txtIsscustvo,txtSport,txtId;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ycheniki);

        txtFio = findViewById(R.id.FIO);
        txtDataRos = findViewById(R.id.DataRosh);
        txtClass = findViewById(R.id.Class);
        txtIntelect = findViewById(R.id.Intelect);
        txtIsscustvo = findViewById(R.id.Isskustvo);
        txtSport = findViewById(R.id.Sport);
        txtId = findViewById(R.id.id);

        dbHandler = new DBHandler(this);




        findViewById(R.id.button_addinfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(txtId.getText().toString());
                String FIO = txtFio.getText().toString();
                String DataRos = txtDataRos.getText().toString();
                String Class = txtClass.getText().toString();
                String Intelect = txtIntelect.getText().toString();
                String Isskustvo = txtIsscustvo.getText().toString();
                String Sport = txtSport.getText().toString();

                Boolean status = dbHandler.addUser(id,FIO,DataRos,Class,Intelect,Isskustvo,Sport);
                if (status)
                    Toast.makeText(addYcheniki.this, "Insert Successfuly", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(addYcheniki.this, "Fail", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
}