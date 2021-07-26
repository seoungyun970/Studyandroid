package com.example.androidstudy.chapter26;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.androidstudy.DBHelper.WordDBHelper;
import com.example.androidstudy.R;

public class EnglishWordActivity extends Activity implements View.OnClickListener {
    WordDBHelper wordDBHelper;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english_word);
        wordDBHelper = new WordDBHelper(this);
        editText = findViewById(R.id.edit_text);

        Button btnInsert = findViewById(R.id.insert);
        Button btnUpdate = findViewById(R.id.update);
        Button btnDelete = findViewById(R.id.delete);
        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db;
        ContentValues row;
        switch (v.getId()) {
            case R.id.insert:
                db = wordDBHelper.getWritableDatabase();
                row = new ContentValues();
                row.put("eng", "boy");
                row.put("han", "머스마");
                db.insert("dic", null, row);
                db.execSQL("INSERT INTO dic VALUES (null,'girl','여자');");
                wordDBHelper.close();
                editText.setText("Insert Success");
                break;
            case R.id.delete:
                db = wordDBHelper.getWritableDatabase();
                db.delete("dic", null, null);
                db.execSQL("DELETE FROM dic");
                wordDBHelper.close();
                editText.setText("Delete Success");
                break;
            case R.id.update:
                db = wordDBHelper.getWritableDatabase();
                row = new ContentValues();
                row.put("han", "소년");
                db.update("dic", row, "eng = 'boy'", null);
                db.execSQL("UPDATE dic SET han ='소년' WHERE eng = 'boy';");
                wordDBHelper.close();
                editText.setText("Update Success");
                break;
            case R.id.select:
                db = wordDBHelper.getWritableDatabase();
                Cursor cursor;
//                메서드로 읽기
//                cursor = db.query("dic",new String[]{"eng","han"},null,null,null,null,null);
//                sql 명령어로 읽기
                cursor = db.rawQuery("SELECT eng,han FROM dic", null);

                String Result = "";
                while (cursor.moveToNext()) {
                    String eng = cursor.getString(0);
                    String han = cursor.getString(1);
                    Result += (eng + " = " + han + "\n");
                }
                if (Result.length() == 0) {
                    editText.setText("Empty Set");
                } else {
                    editText.setText(Result);
                }
                cursor.close();
                wordDBHelper.close();
                break;
        }
    }
}
