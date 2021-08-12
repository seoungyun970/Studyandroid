package com.example.androidstudy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter35Adapter;
import com.example.androidstudy.Adapter.Chapter36Adapter;

import java.util.ArrayList;

public class Chapter36Activity extends Activity {
    ArrayList<String> list;
    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);
        textView.setText("Chapter36 - WebView");

        list = new ArrayList<>();
        list.add("1 - WebView");

        Chapter36Adapter adapter = new Chapter36Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}
