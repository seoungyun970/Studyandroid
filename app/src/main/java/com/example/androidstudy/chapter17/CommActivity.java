package com.example.androidstudy.chapter17;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class CommActivity extends Activity implements View.OnClickListener {
    TextView mText;
    final static int ACT_EDIT = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm);

        mText = findViewById(R.id.text);
        Button btn = findViewById(R.id.btn_edit);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, subActivity.class);
        intent.putExtra("TextIn", mText.getText().toString());
        startActivityForResult(intent, ACT_EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ACT_EDIT:
                if (resultCode == RESULT_OK) {
                    mText.setText(data.getStringExtra("TEXTOUT"));
                }
                break;
        }
    }
}
