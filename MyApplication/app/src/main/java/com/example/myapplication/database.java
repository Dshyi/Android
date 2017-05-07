package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class database extends SQLiteOpenHelper {

    public static final String table_name ="base";
    public static final String TITLE ="title";
    public static final String CONTENT ="content";
    public static final String ID ="_id";
    public static final String TIME ="time";

    public  database(Context context){
        super(context,"base",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + table_name + "("
        +ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +TITLE+" TEXT NOT NULL,"+CONTENT+" TEXT NOT NULL,"
        +TIME +" TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}