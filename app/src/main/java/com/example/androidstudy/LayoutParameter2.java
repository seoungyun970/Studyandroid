package com.example.androidstudy;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LayoutParameter2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setBackgroundColor(Color.LTGRAY);
        TextView textView = new TextView(this);
        textView.setText("text");
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.GREEN);

        linearLayout.addView(textView);
        setContentView(linearLayout);
    }
}
