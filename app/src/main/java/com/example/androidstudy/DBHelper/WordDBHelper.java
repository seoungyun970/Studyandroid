package com.example.androidstudy.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WordDBHelper extends SQLiteOpenHelper {
    public static WordDBHelper wordDBHelper = null;
    private SQLiteDatabase db;


    //singleton
    public static WordDBHelper getInstance(Context context){
        if(wordDBHelper == null) {
            wordDBHelper = new WordDBHelper(context);
        }
        return wordDBHelper;
    }
    public WordDBHelper(Context context) {
        super(context,"English.db",null,1);
        db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE dic ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +"eng TEXT, han TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS dic");
        onCreate(db);
    }
}
