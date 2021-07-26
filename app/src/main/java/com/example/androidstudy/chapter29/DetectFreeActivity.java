package com.example.androidstudy.chapter29;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class DetectFreeActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detect);
        Button btn = findViewById(R.id.brfree);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.postDelayed(() -> {
            Intent intent = new Intent();
            intent.setAction("ZZZ");
            sendBroadcast(intent);
        },1000);
    }
}
