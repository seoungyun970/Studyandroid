package com.example.androidstudy.chapter29;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class NapEnd extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nap_end);

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(NapAlarm.NAPNOTI);

        Button btn = findViewById(R.id.end);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
