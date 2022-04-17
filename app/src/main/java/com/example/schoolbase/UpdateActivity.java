package com.example.schoolbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.schoolbase.database.DBHandler;

public class UpdateActivity extends AppCompatActivity {

    EditText id_input,FIO_input,Data_input,Class_input,Intelect_input,isscustvo_input,sport_input;

    Button btnUpdate;

    String id,fio,dataros,class_,intelect,iscustvo,sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id_input = findViewById(R.id.id_input);
        FIO_input = findViewById(R.id.Fio_input);
        Data_input = findViewById(R.id.DataRosh_input);
        Class_input = findViewById(R.id.Class_input);
        Intelect_input = findViewById(R.id.Intelect_input);
        isscustvo_input = findViewById(R.id.Isskustvo_input);
        sport_input = findViewById(R.id.Sport_input);
        btnUpdate = findViewById(R.id.button_updateinfo);



        getIntentDate();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = id_input.getText().toString();
                fio = FIO_input.getText().toString();
                dataros = Data_input.getText().toString();
                class_ = Class_input.getText().toString();
                intelect = Intelect_input.getText().toString();
                iscustvo = isscustvo_input.getText().toString();
                sport = sport_input.getText().toString();


                DBHandler dbHandler = new DBHandler(UpdateActivity.this);
                dbHandler.updateData(id,fio,dataros,class_,intelect,iscustvo,sport);
            }
        });


    }
        void getIntentDate(){
            if (getIntent().hasExtra("id") && getIntent().hasExtra("fio") &&
                    getIntent().hasExtra("dataros") && getIntent().hasExtra("class") &&
                        getIntent().hasExtra("intelect") && getIntent().hasExtra("iscustvo")
                            && getIntent().hasExtra("sport")){

                id = getIntent().getStringExtra("id");
                fio = getIntent().getStringExtra("fio");
                dataros = getIntent().getStringExtra("dataros");
                class_ = getIntent().getStringExtra("class");
                intelect = getIntent().getStringExtra("intelect");
                iscustvo = getIntent().getStringExtra("iscustvo");
                sport = getIntent().getStringExtra("sport");

                //Setting
                id_input.setText(id);
                FIO_input.setText(fio);
                Data_input.setText(dataros);
                Class_input.setText(class_);
                Intelect_input.setText(intelect);
                isscustvo_input.setText(iscustvo);
                sport_input.setText(sport);



            }else{
                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            }
        }





    }
