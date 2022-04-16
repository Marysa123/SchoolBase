package com.example.schoolbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDB) {
        sqLiteDB.execSQL("create Table users(username Text primary key,password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDB, int i, int i1) {
        sqLiteDB.execSQL("drop Table if exists users");
    }

    public  Boolean insertData(String username,String password){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = database.insert("users",null,contentValues);

        if (result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public  Boolean checkusername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ?",new String[] {username});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public  Boolean checkusernamePassword(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password = ?",new String[] {username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }

    }
}
