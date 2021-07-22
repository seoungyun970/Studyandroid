package com.example.androidstudy.chapter17;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class subActivity extends Activity implements View.OnClickListener {
    EditText mText;
    final static int ACT_EDIT = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_edit);
        mText = findViewById(R.id.str_edit);

        Intent intent = getIntent();
        String text = intent.getStringExtra("TextIn");
        if (text != null) {
            mText.setText(text);
        }
        Button btn = findViewById(R.id.btn_ok);
        Button btn2 = findViewById(R.id.btn_cancel);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                Intent intent = new Intent();
                intent.putExtra("TEXTOUT", mText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            mText.setText(data.getStringExtra("TEXTOUT"));
        }
    }
}
