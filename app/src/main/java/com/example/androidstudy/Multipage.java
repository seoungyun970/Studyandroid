package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Multipage extends Activity implements View.OnClickListener {
    View mPage1,mPage2,mPage3 ;
    Button mBtnPage1,mBtnPage2,mBtnPage3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multipage);
        mPage1 = findViewById(R.id.page1);
        mPage2 = findViewById(R.id.page2);
        mPage3 = findViewById(R.id.page3);
        mBtnPage1 = findViewById(R.id.btnPage1);
        mBtnPage2 = findViewById(R.id.btnPage2);
        mBtnPage3 = findViewById(R.id.btnPage3);

        mBtnPage1.setOnClickListener(this);
        mBtnPage2.setOnClickListener(this);
        mBtnPage3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPage1.setVisibility(View.INVISIBLE);
        mPage2.setVisibility(View.INVISIBLE);
        mPage3.setVisibility(View.INVISIBLE);

        switch (v.getId()) {
            case R.id.btnPage1:
                mPage1.setVisibility(View.VISIBLE);
                break;
            case R.id.btnPage2:
                mPage2.setVisibility(View.VISIBLE);
                break;
            case R.id.btnPage3:
                mPage3.setVisibility(View.VISIBLE);
                break;

        }
    }
}
