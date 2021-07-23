package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class ANRActivity extends Activity implements View.OnClickListener {
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
                TextView tvCounter = findViewById(R.id.txt_counter);
                int count = Integer.parseInt(tvCounter.getText().toString());
                tvCounter.setText(Integer.toString(count + 1));
                break;
            case R.id.btn_upload:
                doUpload();
                Toast.makeText(this,"업로드를 완료했습니다.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    void doUpload() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
    }
}
