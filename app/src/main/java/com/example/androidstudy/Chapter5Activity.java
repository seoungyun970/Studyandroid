package com.example.androidstudy;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter4Adapter;
import com.example.androidstudy.Adapter.Chapter5Adapter;

import java.util.ArrayList;

public class Chapter5Activity extends Activity {
    ArrayList<String> list;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);

        textView.setText("Chapter5 - 레이아웃");

        list = new ArrayList<>();
        list.add("1 - relative 배치");
        list.add("2 - Framelayout");
        list.add("3 - multipage");
        list.add("4 - CodeLayout");
        list.add("5 - Inflation");
        list.add("6 - Inflation2");
        list.add("7 - Inflation3");
        list.add("8 - Inflation4");
        list.add("9 - Inflation5");

        Chapter5Adapter adapter = new Chapter5Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
