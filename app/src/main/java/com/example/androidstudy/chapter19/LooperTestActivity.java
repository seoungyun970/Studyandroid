package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class LooperTestActivity extends Activity implements View.OnClickListener {
    int mMainvalue = 0;
    TextView mMainText, mBackText;
    EditText mNumEdit;
    CalcThread mThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.looper_test);

        mMainText = findViewById(R.id.main_value);
        mBackText = findViewById(R.id.back_value);

        mNumEdit = findViewById(R.id.number);
        Button btn1 = findViewById(R.id.increase);
        Button btn2 = findViewById(R.id.root);
        Button btn3 = findViewById(R.id.square);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        mThread = new CalcThread(mHandler);
        mThread.setDaemon(true);
        mThread.start();
    }

    @Override
    public void onClick(View v) {
        Message msg;
        switch (v.getId()) {
            case R.id.increase:
                mMainvalue++;
                mMainText.setText("MainValue : " + mMainvalue);
                break;
            case R.id.square:
                msg = new Message();
                msg.what = 0;
                msg.arg1 = Integer.parseInt(mNumEdit.getText().toString());
                mThread.mBackHandler.sendMessage(msg);
                break;
            case R.id.root:
                msg = new Message();
                msg.what = 1;
                msg.arg1 = Integer.parseInt(mNumEdit.getText().toString());
                mThread.mBackHandler.sendMessage(msg);
                break;
        }
    }

    Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mBackText.setText("Square result : " + msg.arg1);
                    break;
                case 1:
                    mBackText.setText("Root Result : " + ((Double) msg.obj).doubleValue());
                    break;
            }
        }
    };



    class CalcThread extends Thread {
        Handler mMainHandler;
        Handler mBackHandler;

        public CalcThread(Handler handler) {
            mMainHandler = handler;
        }

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            mBackHandler = new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    Message retmsg = new Message();
                    switch (msg.what) {
                        case 0:
                            try {
                                Thread.sleep(200);
                            } catch (Exception e) {

                            }
                            retmsg.what = 0;
                            retmsg.arg1 = msg.arg1 * msg.arg1;
                            break;
                        case 1:
                            try {
                                Thread.sleep(200);
                            } catch (Exception e) {

                            }
                            retmsg.what = 1;
                            retmsg.obj = new Double(Math.sqrt((double)msg.arg1));
                            break;
                    }
                    mMainHandler.sendMessage(retmsg);
                }
            };
            Looper.loop();
        }
    }
}
