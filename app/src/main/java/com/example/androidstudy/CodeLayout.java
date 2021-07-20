package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CodeLayout extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codelayout);

        LinearLayout myLinear = findViewById(R.id.myLinear);
        myLinear.setOrientation(LinearLayout.HORIZONTAL);

        Button myBtn = findViewById(R.id.myButton);
        myBtn.setTextSize(40);
        EditText MyEdit = findViewById(R.id.myEdit);
        MyEdit.setBackgroundColor(0xff00ff00);
    }
}
