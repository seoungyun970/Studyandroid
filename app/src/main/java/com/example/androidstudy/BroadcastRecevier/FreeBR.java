package com.example.androidstudy.BroadcastRecevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FreeBR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context,com.example.androidstudy.chapter28.AsyncDownHtml.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
