package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter4Adapter;

import java.util.ArrayList;

public class Chapter4Activity extends Activity {
    ArrayList<String> list;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);
        textView = findViewById(R.id.textView);

        textView.setText("Chapter4 - 뷰");
        list = new ArrayList<>();
        list.add("1 - ButtonEdit");

        Chapter4Adapter adapter = new Chapter4Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
