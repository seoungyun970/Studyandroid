package com.example.androidstudy.chapter30;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NewsService2 extends IntentService {
    public NewsService2() {
        //생성자 안에 호출되는 이름은 디버깅에만 사용됨 별다른 의미는 없음
        super("NewsThread");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String []arNews = {
                "111111111",
                "22222222",
                "33333"
        };
        for (int idx = 0 ;idx <arNews.length ;idx++) {
            Message msg =new Message();
            msg.what = 0;
            msg.obj = arNews[idx %arNews.length];
            mHandler.sendMessage(msg);
            try {
                Thread.sleep(5000);
            } catch (Exception e) {

            }
        }
    }
    Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 0) {
                String news = (String)msg.obj;
                Toast.makeText(NewsService2.this,news,Toast.LENGTH_SHORT).show();
            }
        }
    };
}
