package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Frame extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ImageView img = findViewById(R.id.img);
        if (img.getVisibility() == View.VISIBLE) {
            img.setVisibility(View.INVISIBLE);
        } else {
            img.setVisibility(View.VISIBLE);
        }
    }
}
