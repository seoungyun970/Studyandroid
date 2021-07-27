package com.example.androidstudy.chapter30;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class NewsController extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_controller);
        Button btn = findViewById(R.id.news_start);
        Button btn1 = findViewById(R.id.news_end);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.news_start:
                intent = new Intent(this,NewsService.class);
                startService(intent);
                break;
            case R.id.news_end:
                intent = new Intent(this,NewsService.class);
                stopService(intent);
                break;
        }
    }
}
