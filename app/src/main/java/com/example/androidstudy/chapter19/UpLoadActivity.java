package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class UpLoadActivity extends Activity implements View.OnClickListener {
    Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);
        mBtn = findViewById(R.id.upLoad);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new AlertDialog.Builder(this)
                .setTitle("질문")
                .setMessage("업로드 하시겠습니까?")
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doUpload();
                    }
                })
                .setNegativeButton("아니오", null)
                .show();
    }

    void doUpload() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            Toast.makeText(this, "업로드를 완료", Toast.LENGTH_SHORT).show();
        }
    }
}
