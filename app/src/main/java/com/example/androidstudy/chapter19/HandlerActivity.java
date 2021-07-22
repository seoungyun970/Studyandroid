package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class HandlerActivity extends Activity implements View.OnClickListener {
    int mMainValue = 0;
    int mBackValue = 0;
    TextView mMainText,mBackText;
    Handler mHandler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_test);

        mMainText = findViewById(R.id.main_value);
        mBackText = findViewById(R.id.back_value);

        BackThread backThread = new BackThread(mHandler);
        backThread.setDaemon(true);
        backThread.start();

        Button btn = findViewById(R.id.increase);
        btn.setOnClickListener(this);

        mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                if(msg.what == 0) {
                    mBackText.setText("BackValue : " + mBackValue);
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        mMainValue++;
        mMainText.setText("MainValue : " + mMainValue);
        mBackText.setText("BackValue : " + mBackValue);
    }

    class BackThread extends Thread {
        public BackThread(Handler handler) {
            mHandler = handler;
        }

        public void run() {
            while (true) {
                mBackValue ++;
                Message msg = new Message();
                msg.what = 0;
                msg.arg1 = mBackValue;
                mHandler.sendMessage(msg);
                try{
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }
    }

}