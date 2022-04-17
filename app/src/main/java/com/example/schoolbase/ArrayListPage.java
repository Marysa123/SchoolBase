package com.example.schoolbase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.schoolbase.database.DBHandler;
import com.example.schoolbase.database.User;

import java.util.ArrayList;

public class ArrayListPage extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> id,Fio,dataros,class_,intelect,iscusstvo,sport;
    DBHandler dbHandler;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list_page);
        recyclerView = findViewById(R.id.recyclesview);
        dbHandler = new DBHandler(this);
        id = new ArrayList<>();
        Fio = new ArrayList<>();
        dataros = new ArrayList<>();
        class_ = new ArrayList<>();
        intelect = new ArrayList<>();
        iscusstvo = new ArrayList<>();
        sport = new ArrayList<>();
        adapter = new MyAdapter(this,id,Fio,dataros,class_,intelect,iscusstvo,sport);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        displaydata();
    }

    @SuppressLint("Range")
    private void displaydata() {
        Cursor cursor = dbHandler.getdata();
        if (cursor.getCount()==0 && cursor.moveToFirst()) {
            Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();

        }
        else{
            if (cursor != null)
                if (cursor.moveToFirst()) {
                    do {
                        id.add(cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_ID)));
                        Fio.add(cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_FIO)));
                        dataros.add(cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_DataRos)));
                        class_.add(cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_Class)));
                        intelect.add(cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_Intelect)));
                        iscusstvo.add(cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_Isscustvo)));
                        sport.add(cursor.getString(cursor.getColumnIndex(User.UserDetails.COL_Sport)));;
                    } while (cursor.moveToNext());
                }
        }
    }
}
