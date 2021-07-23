package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class ANR2Activity extends Activity implements View.OnClickListener {
    boolean bUploading = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);
        Button btnCrease = findViewById(R.id.btn_increase);
        Button btnUpload = findViewById(R.id.btn_upload);
        btnCrease.setOnClickListener(this);
        btnUpload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_increase:
                TextView texCounter = findViewById(R.id.txt_counter);
                int count = Integer.parseInt(texCounter.getText().toString());
                texCounter.setText(Integer.toString(count + 1));
                break;
            case R.id.btn_upload:
                if (bUploading) {
                    return;
                }
                Thread uploadThread = new Thread() {
                    public void run() {
                        doUpload();
                        mCompleteHandler.sendEmptyMessage(0);
                    }
                };
                bUploading = true;
                uploadThread.start();
                break;
        }
    }

    public Handler mCompleteHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            bUploading = false;
            Toast.makeText(ANR2Activity.this,"finish upload",Toast.LENGTH_SHORT).show();
        }
    };

    void doUpload() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
    }


}
