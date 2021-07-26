package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter28Adapter;
import com.example.androidstudy.Adapter.Chapter29Adapter;

import java.util.ArrayList;

public class Chapter29Activity extends Activity {
    ArrayList<String> list;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);
        textView.setText("Chapter28 - 네트워크");

        list = new ArrayList<>();
//        list.add("1 - noti");
//        list.add("2 - network(StrictMode)");
//        list.add("3 - AsyncDownHtml");
//        list.add("4 - Download image");
//        list.add("5 - Download image2");
//        list.add("6 - DownloadManager");
//        list.add("7 - JsonArray");


        Chapter29Adapter adapter = new Chapter29Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}