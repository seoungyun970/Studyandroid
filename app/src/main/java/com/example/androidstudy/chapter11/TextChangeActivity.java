package com.example.androidstudy.chapter11;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class TextChangeActivity extends Activity {
    EditText mEdit;
    TextView mText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textchange);

        mEdit = findViewById(R.id.edit);
        mText = findViewById(R.id.text);
        mEdit.addTextChangedListener(mWatcher);
    }

    TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mText.setText("echo : " + s);
        }
    };
}
