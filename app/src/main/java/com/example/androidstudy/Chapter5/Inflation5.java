package com.example.androidstudy.Chapter5;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class Inflation5 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inflation5);
        Button btn = (Button) findViewById(R.id.btnNewMessage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rel = (RelativeLayout) View.inflate(Inflation5.this, R.layout.newmessage, null);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);
                if (linearLayout.getChildCount() % 2 == 0) {
                    rel.setBackgroundColor(Color.GRAY);
                } else {
                    rel.setBackgroundColor(Color.RED);
                }
                linearLayout.addView(rel);
            }
        });
    }
}
