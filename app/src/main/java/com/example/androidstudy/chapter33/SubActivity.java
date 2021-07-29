package com.example.androidstudy.chapter33;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.MainActivity;
import com.example.androidstudy.R;

import java.util.ArrayList;

public class SubActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ArrayList<String> array = SharedPreferencesManager.getStringArray(this,"inputArray");
        Log.d(">>>",array.toString());
        Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            SharedPreferencesManager.clear(this);
            Toast.makeText(this,"로그아웃",Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
