package com.example.androidstudy.chapter11;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class ListItemSelectActivity extends Activity {
    String[] arGeneral = {"k", "lee", "kim", "mmmmmm"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_test);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arGeneral);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(mItemClickListener);
    }

    AdapterView.OnItemClickListener mItemClickListener = (parent, view, position, id) -> {
        String mes;
        mes = "Select Item = " + arGeneral[position];
        Toast.makeText(ListItemSelectActivity.this, mes, Toast.LENGTH_LONG).show();
    };
}
