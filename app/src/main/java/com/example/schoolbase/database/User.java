package com.example.schoolbase.database;

import android.provider.BaseColumns;

import com.example.schoolbase.R;

public class User {
    private User() {
    }
    public static final  class  UserDetails implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String COL_ID = "id";
        public static final String COL_FIO = "fio";
        public static final String COL_DataRos = "dataros";
        public static final String COL_Class = "class";
        public static final String COL_Intelect = "intelect";
        public static final String COL_Isscustvo = "isscustvo";
        public static final String COL_Sport = "sport";





    }
}
