package com.example.androidstudy.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductDBHelper extends SQLiteOpenHelper {
    public ProductDBHelper(Context context) {
        super(context,"Product.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE product (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT , price INTEGER);");
        db.execSQL("INSERT INTO product VALUES(null, '오징어 땅콩', 900);");
        db.execSQL("INSERT INTO product VALUES(null, '농심 포테토 칩', 2000);");
        db.execSQL("INSERT INTO product VALUES(null, '로보투 태권 v', 1500);");
        db.execSQL("INSERT INTO product VALUES(null, '윈도우즈 api 정', 32000);");
        db.execSQL("INSERT INTO product VALUES(null, '롯데월드 입장권', 42000);");
        db.execSQL("INSERT INTO product VALUES(null, '서울랜드 입장권', 22000);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS product");
        onCreate(db);
    }
}
