package com.example.androidstudy.chapter30;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.widget.MediaController;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewsService extends Service {
    Boolean mQuit;
    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"Service End",Toast.LENGTH_SHORT).show();
        mQuit = true;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent,flags,startId);

        mQuit = false;
        NewsThread thread = new NewsThread(this,mHandler);
        thread.start();
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class NewsThread extends Thread {
        NewsService mParent;
        Handler mHandler;
        String[] arNews = {
                "일본 .....",
                "한국 .....",
                "춘천 .....",
                "안드로이드 ."
        };
        public NewsThread(NewsService mParent, Handler handler) {
            mParent = mParent;
            mHandler = handler;
        }

        @Override
        public void run() {
            for (int idx = 0 ; mQuit == false; idx ++) {
                Message msg = new Message();
                msg.what = 0;
                msg.obj = arNews[idx % arNews.length];
                mHandler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }
    }
    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 0) {
                String news = (String)msg.obj;
                Toast.makeText(NewsService.this,news,Toast.LENGTH_SHORT).show();
            }
        }
    };
}
