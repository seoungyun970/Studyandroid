package com.example.androidstudy.chapter28;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downlmage2 extends Activity implements View.OnClickListener {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downlmage);
        Button btn = findViewById(R.id.btn_down);
        imageView = findViewById(R.id.result);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_down:
                String imageUrl = "https://newsimg.hankookilbo.com/cms/articlerelease/2021/04/23/6ab95831-7075-4b6f-92b6-c04bd3d95a91.jpg";
                int idx = imageUrl.lastIndexOf('/');
                String localImage = imageUrl.substring(idx + 1);
                String path = Environment.getDataDirectory().getAbsolutePath();
                path += "/data/com.example.androidstudy/files/" + localImage;

                if (new File(path).exists()) {
                    Toast.makeText(this,"Bitmap is exist",Toast.LENGTH_SHORT).show();
                    imageView.setImageBitmap(BitmapFactory.decodeFile(path));
                } else {
                    Toast.makeText(this,"bitmap is not exist",Toast.LENGTH_SHORT).show();
                    (new DownLoadThread(imageUrl,localImage)).start();
                }
        }
    }
    private class DownLoadThread extends Thread {
        String mAddr;
        String mFile;
        public DownLoadThread(String mAddr,String mFile) {
            this.mAddr = mAddr;
            this.mFile = mFile;
        }

        public void run() {
            URL imageurl;
            int read;
            try {
                imageurl = new URL(mAddr);
                HttpURLConnection conn = (HttpURLConnection)imageurl.openConnection();
                int len = conn.getContentLength();
                byte[] raster = new byte[len];

                InputStream is = conn.getInputStream();
                FileOutputStream fos = openFileOutput(mFile,0);

                for (;;) {
                    read = is.read(raster);
                    if (read <= 0) {
                        break;
                    }
                    fos.write(raster,0,read);
                }
                is.close();
                fos.close();
                conn.disconnect();
            } catch (Exception e) {
                mFile = null;
            }
            Message message = mAfterDown.obtainMessage();
            message.obj = mFile;
            mAfterDown.sendMessage(message);
        }

        Handler mAfterDown = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                if (msg.obj != null) {
                    String path = Environment.getDataDirectory().getAbsolutePath();
                    path += "/data/com.example.androidstudy/files/" + (String)msg.obj;
                    imageView.setImageBitmap(BitmapFactory.decodeFile(path));
                } else {
                    Toast.makeText(Downlmage2.this,"File not found",Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
