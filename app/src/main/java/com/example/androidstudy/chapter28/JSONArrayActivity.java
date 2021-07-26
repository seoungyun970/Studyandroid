package com.example.androidstudy.chapter28;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import org.json.JSONArray;

public class JSONArrayActivity extends Activity implements View.OnClickListener {
    TextView mResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_array);

        mResult = findViewById(R.id.result);
        Button btn = findViewById(R.id.parse);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String json = "[8,9,6,2,9]";
        try {
            int sum = 0;
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0 ; i <jsonArray.length(); i++) {
                sum += jsonArray.getInt(i);
            }
            mResult.setText("sum = " + sum);
        } catch (Exception e) {
            Toast.makeText(v.getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
