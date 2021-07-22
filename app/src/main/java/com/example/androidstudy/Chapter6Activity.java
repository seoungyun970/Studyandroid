package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter5Adapter;
import com.example.androidstudy.Adapter.Chapter6Adapter;

import java.util.ArrayList;

public class Chapter6Activity extends Activity {
    ArrayList<String> list;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);

        textView.setText("Chapter6 - 레이아웃 관리");
        list = new ArrayList<>();
        list.add("1 - LayoutParameter");
        list.add("2 - LayoutParameter2");
        list.add("3 - LayoutParameter3");

        Chapter6Adapter adapter = new Chapter6Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}