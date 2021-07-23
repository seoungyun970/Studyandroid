package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class ThreadTestActivity extends Activity implements View.OnClickListener {
    int mMainValue = 0;
    int mBackValue = 0;
    TextView mMainText, mBackText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_test);

        mMainText = findViewById(R.id.main_value);
        mBackText = findViewById(R.id.back_value);

        BackThread thread = new BackThread();
        thread.setDaemon(true);
        thread.start();

        Button btn = findViewById(R.id.increase);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mMainValue++;
        mMainText.setText("MainValue : " + mMainValue);
        mBackText.setText("BackValue : " + mBackValue);
    }

    class BackThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                System.out.println(">>>>>>>>>>>>>>>");
                mBackValue++;
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }
    }
}
