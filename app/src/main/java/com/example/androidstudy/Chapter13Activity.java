package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter12Adapter;
import com.example.androidstudy.Adapter.Chapter13Adapter;

import java.util.ArrayList;

public class Chapter13Activity extends Activity {
    ArrayList<String> list;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);
        textView.setText("Chapter13 - 고급위젯");

        list = new ArrayList<>();
        list.add("1 - DateTimeActivity");
        list.add("2 - DatePicker");
        list.add("3 - webView");

        Chapter13Adapter adapter = new Chapter13Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}
