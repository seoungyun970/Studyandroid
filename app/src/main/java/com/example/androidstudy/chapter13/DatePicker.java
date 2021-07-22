package com.example.androidstudy.chapter13;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class DatePicker extends Activity {
    View mDate;
    TextView mTxtDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);
        mDate = findViewById(R.id.date_picker);
        mTxtDate = findViewById(R.id.tv_date);
    }
}
