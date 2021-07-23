package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class LongTimeActivity extends Activity implements View.OnClickListener {
    int mValue;
    TextView mText;
    ProgressDialog mProgress;
    AlertDialog.Builder builder;
    boolean mQuit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.long_time_activity);

        mText = findViewById(R.id.text);
        Button btnUpdate = findViewById(R.id.update);
        btnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mValue = 0;
        mQuit = false;
        mHandler.sendEmptyMessage(0);
//        upDate();
        dialog();
    }
    public void dialog() {
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Updating")
                .setMessage("wait..").show();
//                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        mQuit = true;
//                    }
//                }).show();

        mHandler.sendEmptyMessage(0);
    }

//    public void upDate() {
//        for (int i = 0 ; i < 100 ; i++ ) {
//            mValue++ ;
//            mText.setText(Integer.toString(mValue));
//
//            try {
//                Thread.sleep(50);
//            } catch (Exception e) {
//
//            }
//        }
//    }
    Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            mValue ++;
            mText.setText(Integer.toString(mValue));
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
            if (mValue < 100 && mQuit == false) {
                mHandler.sendEmptyMessage(0);
            }
        }
    };
}
