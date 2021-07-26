package com.example.androidstudy.chapter29;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class OnSaveZone extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onsavezone);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("ZZZ");
        registerReceiver(mSaveZoneBR,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mSaveZoneBR);
    }
    BroadcastReceiver mSaveZoneBR = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"공짜다!",Toast.LENGTH_SHORT).show();
        }
    };
}
