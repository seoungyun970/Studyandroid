package com.example.androidstudy.chapter28;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.NetworkOnMainThreadException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncDownHtml extends Activity implements View.OnClickListener {
    ProgressDialog mProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_html);
        Button btn = findViewById(R.id.down);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mProgress = ProgressDialog.show(AsyncDownHtml.this,"Wait","DownLoading....");
        DownThread thread = new DownThread("Https://www.google.com");
        thread.start();
    }
    private class DownThread extends Thread {
        String mAddr;

        public DownThread(String mAddr) {
            this.mAddr = mAddr;
        }
        public void run() {
            String result = DownLoadHtml(mAddr);
            Message message = mAfterDown.obtainMessage();
            message.obj = result;
            mAfterDown.sendMessage(message);
        }
    }

    String DownLoadHtml(String addr) {
        StringBuilder html = new StringBuilder();
        try {
            URL url = new URL(addr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn != null) {
                conn.setConnectTimeout(100000);
                conn.setUseCaches(false);

                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    for (;;) {
                        String line = br.readLine();
                        if (line == null) break;
                        html.append(line + "\n");
                    }
                    br.close();
                }
                conn.disconnect();
            }
        } catch (NetworkOnMainThreadException e) {
            return "Error : 메인 스레드 네트워크 작업 에러 - " +e.getMessage();
        } catch (Exception e) {
            return "Error : " +e.getMessage();
        }
        return html.toString();
    }
    Handler mAfterDown = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            mProgress.dismiss();
            TextView result = findViewById(R.id.result);
            result.setText((String)msg.obj);
        }
    };
}
