package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter30Adapter;
import com.example.androidstudy.Adapter.Chapter32Adapter;

import java.util.ArrayList;

public class Chapter32Activity extends Activity {
    ArrayList<String> list;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);
        textView.setText("Chapter32 - gps");

        list = new ArrayList<>();
        list.add("1 - gps");
        list.add("2 - gpsProvider");
        list.add("3 - readlocation");
        list.add("4 - geocoding");



        Chapter32Adapter adapter = new Chapter32Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}