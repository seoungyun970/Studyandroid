package com.example.androidstudy.chapter13;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeActivity extends Activity implements View.OnClickListener {
    Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_test);

        mBtn = findViewById(R.id.button);
        mBtn.setOnClickListener(this);
        refresh();
    }

    public void refresh() {
        StringBuilder time = new StringBuilder();

        long epoch = System.currentTimeMillis();
        time.append("epoch = " + epoch + "\n");

        Calendar cal = new GregorianCalendar();
        time.append("new  = " + cal.get(Calendar.YEAR) + "년 " + cal.get(Calendar.MONTH) + 1 + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일 ");

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        time.append("now = " + sdf.format(now) + "\n");

        Calendar tom = new GregorianCalendar();
        tom.add(Calendar.DAY_OF_MONTH, 1);
        Date tomDate = tom.getTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
        time.append("tomorrow = " + sdf2.format(tomDate) + "\n");

        TextView result = findViewById(R.id.result);
        result.setText(time.toString());
    }

    @Override
    public void onClick(View v) {
        refresh();
    }
}
