package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter25Adapter;
import com.example.androidstudy.Adapter.Chapter26Adapter;

import java.util.ArrayList;

public class Chapter26Activity extends Activity {
    ArrayList<String> list;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);
        textView.setText("Chapter26 - SQLite");

        list = new ArrayList<>();
        list.add("1 - EnglishWord");
        list.add("2 - SQlite_DB");
        list.add("3 - 프레퍼런스");

        Chapter26Adapter adapter = new Chapter26Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}