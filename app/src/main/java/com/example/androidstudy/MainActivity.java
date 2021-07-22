package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidstudy.Adapter.MainActivityAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add("chapter4 - 뷰");
        list.add("chapter5 - 레이아웃");
        list.add("chapter6 - 레이아웃 관리");
        list.add("chapter7 - 출력");
        list.add("chapter11 - 기본위젯");
        list.add("chapter12 - 어댑터뷰");
        list.add("chapter13 - 고급위젯");
        list.add("chapter16 - 대화상자");
        list.add("chapter17 - activity");
        list.add("chapter19 - 스레드");

        MainActivityAdapter adapter = new MainActivityAdapter(list);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}