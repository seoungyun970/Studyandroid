package com.example.androidstudy.chapter33;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class SimpleSharedPreferences extends Activity {
    private TextView tvPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedprefences);

        String text = SharedPreferencesManager.getString(this,"rebuild");
        if (text.equals("")) {
            text = "저장된 데이터가 없습니다.";
            SharedPreferencesManager.setString(this,"rebuild","111111");
        }
        tvPreferences = findViewById(R.id.tv_preferences);
        tvPreferences.setText(text);
    }
}
