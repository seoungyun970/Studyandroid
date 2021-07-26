package com.example.androidstudy.chapter28;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class DownloadManagerActivity extends Activity implements View.OnClickListener {
    DownloadManager downloadManager;
    long mId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_manager);

        downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        Button btn = findViewById(R.id.btn_queue);
        btn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_queue:
                Uri uri = Uri.parse("https://media0.giphy.com/media/3oz8xZKXxXR0Amtlde/200w.gif?cid=82a1493bi83m99tdjswwh6uvw7te861cs00sgf5o5d4udu08&rid=200w.gif&ct=g");
                DownloadManager.Request req = new DownloadManager.Request(uri);
                req.setTitle("테스트 다운로드");
                req.setDescription("이미지 파일을 다운로드 받습니다.");
                req.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                mId = downloadManager.enqueue(req);

                IntentFilter filter = new IntentFilter();
                filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                registerReceiver(broadcastReceiver,filter);
                break;
        }
    }
    public void onPause() {
        super. onPause();
        if (mId != 0) {
            unregisterReceiver(broadcastReceiver);
        }
    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"다운로드 완료",Toast.LENGTH_SHORT).show();
        }
    };
}
