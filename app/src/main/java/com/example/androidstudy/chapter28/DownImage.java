package com.example.androidstudy.chapter28;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import java.io.InputStream;
import java.net.URL;

public class DownImage extends Activity implements View.OnClickListener {
    ImageView mImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downlmage);

        mImageView = findViewById(R.id.result);
        Button btn = findViewById(R.id.btn_down);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_down:
            new DownThread("https://newsimg.hankookilbo.com/cms/articlerelease/2021/04/23/6ab95831-7075-4b6f-92b6-c04bd3d95a91.jpg").start();
            break;
        }
    }

    class DownThread extends Thread {
        String mAddr;

        public DownThread(String mAddr) {
            this.mAddr = mAddr;
        }

        public void run() {
            try {
                InputStream is = new URL(mAddr).openStream();
                Bitmap bit = BitmapFactory.decodeStream(is);
                is.close();
                Message message = mAfterDown.obtainMessage();
                message.obj = bit;
                mAfterDown.sendMessage(message);
            } catch (Exception e) {

            }
        }
    }

    Handler mAfterDown = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            Bitmap bit = (Bitmap)msg.obj;
            if (bit == null) {
                Toast.makeText(DownImage.this,"bitmap is null ",Toast.LENGTH_SHORT).show();
            } else {
                mImageView.setImageBitmap(bit);
            }
        }
    };
}
