package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Adapter.Chapter11Adapter;
import com.example.androidstudy.Adapter.Chapter12Adapter;

import java.util.ArrayList;

public class Chapter12Activity extends Activity {
    ArrayList<String> list;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter_sample);

        textView = findViewById(R.id.textView);
        textView.setText("Chapter12 - 리스트뷰");

        list = new ArrayList<>();
        list.add("1 - ListviewActivity");
        list.add("2 - ListFromArrayActivity");
        list.add("3 - ListAttrActivity");
        list.add("4 - ListItemSelectActivity");
        list.add("5 - ListAddDelActivity");
        list.add("6 - ListAddDelMultiActivity");
        list.add("7 - SpinnerActivity");

        Chapter12Adapter adapter = new Chapter12Adapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
