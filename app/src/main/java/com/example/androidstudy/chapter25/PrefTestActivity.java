package com.example.androidstudy.chapter25;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class PrefTestActivity extends Activity {
    TextView textName;
    TextView textStNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretest);

        textName = findViewById(R.id.name);
        textStNum = findViewById(R.id.stnum);

        SharedPreferences pref = getSharedPreferences("PrefTest",0);
        String name = pref.getString("name","이름 없음");
        textName.setText(name);

        int stNum = pref.getInt("stNum",20101234);
        textStNum.setText("" + stNum);

    }
    public void onPause() {
        super.onPause();
        SharedPreferences pref = getSharedPreferences("PrefTest" ,0);
        SharedPreferences.Editor edit = pref.edit();

        String name = textName.getText().toString();
        int stNum = 0;
        try {
            stNum = Integer.parseInt(textStNum.getText().toString());
        } catch (Exception e) {

        }
        edit.putString("name",name);
        edit.putInt("stNum",stNum);
        edit.commit();
    }

}
