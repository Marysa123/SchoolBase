package com.example.schoolbase.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "User.db";
    public  static  final int DB_VERSION = 1;

    public DBHandler(Context context) {

        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String USER_TABLE = "CREATE TABLE "+ User.UserDetails.TABLE_NAME+" ( "+
                User.UserDetails.COL_ID+" INTEGER PRIMARY KEY,"+
                User.UserDetails.COL_FIO+" TEXT,"+
                User.UserDetails.COL_DataRos+" TEXT,"+
                User.UserDetails.COL_Class+" TEXT,"+
                User.UserDetails.COL_Intelect+" TEXT,"+
                User.UserDetails.COL_Isscustvo+" TEXT,"+
                User.UserDetails.COL_Sport+" TEXT )";

        sqLiteDatabase.execSQL(USER_TABLE);
    }

    //----------------------------INSERT
    public boolean addUser(int id,String FIO,String DataRos,String Class,String Intelect,String Isscustvo,String Sport){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(User.UserDetails.COL_ID,id);
        values.put(User.UserDetails.COL_FIO,FIO);
        values.put(User.UserDetails.COL_DataRos,DataRos);
        values.put(User.UserDetails.COL_Class,Class);
        values.put(User.UserDetails.COL_Intelect,Intelect);
        values.put(User.UserDetails.COL_Isscustvo,Isscustvo);
        values.put(User.UserDetails.COL_Sport,Sport);

        long sid = database.insert(User.UserDetails.TABLE_NAME,null,values);

        if (sid>0){
            return true;

        }
        else {
            return false;
        }
    }
    public Cursor getdata(){
        String query = "SELECT * FROM " + User.UserDetails.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (db != null){
           cursor = db.rawQuery(query,null);
        }
        return cursor;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists user");
    }
}
