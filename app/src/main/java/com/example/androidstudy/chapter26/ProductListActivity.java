package com.example.androidstudy.chapter26;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

import com.example.androidstudy.DBHelper.ProductDBHelper;
import com.example.androidstudy.R;

import java.util.List;

public class ProductListActivity extends Activity {
    ProductDBHelper mHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        mHelper = new ProductDBHelper(this);
        Cursor cursor;
        SQLiteDatabase db = mHelper.getWritableDatabase();

        cursor = db.rawQuery("SELECT * FROM product",null);
        startManagingCursor(cursor);

        SimpleCursorAdapter adapter = null;
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,new String[]{"name","price"},new int[] {android.R.id.text2});
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
