package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter17Adapter;
import com.example.androidstudy.Adapter.Chapter19Adapter;

import java.util.ArrayList;

public class Chapter19Activity extends Activity {
    ArrayList<String> list;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);
        textView.setText("Chapter19 - thread");

        list = new ArrayList<>();
        list.add("1 - Thread");
        list.add("2 - Thread(Runnable)");
        list.add("3 - Handler");
        list.add("4 - looper");

        Chapter19Adapter adapter = new Chapter19Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}