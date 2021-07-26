package com.example.androidstudy.chapter29;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class NapAlarm extends Activity implements View.OnClickListener {
    static final int NAPNOTI = 1;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nap_alarm);

        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Button btn = findViewById(R.id.start);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"hi",Toast.LENGTH_SHORT).show();
        v.postDelayed(() -> {
            Intent intent = new Intent(NapAlarm.this,NapEnd.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent content = PendingIntent.getActivity(NapAlarm.this,0,intent,0);

            Notification notification = new Notification.Builder(NapAlarm.this)
                    .setTicker("일어나세요")
                    .setContentTitle("일어나!")
                    .setSubText("일을 하자")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentIntent(content)
                    .build();

            notificationManager.notify(NapAlarm.NAPNOTI,notification);
        },1000);
    }
}
