package com.example.androidstudy.chapter11;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class GramPriceActivity extends Activity {
    EditText mGram,mWon;
    TextView mPrice;
    EditText mGram2,mWon2;
    TextView mPrice2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gram_price);

        mGram = findViewById(R.id.gram);
        mGram2 = findViewById(R.id.gram2);
        mWon = findViewById(R.id.won);
        mPrice = findViewById(R.id.price);
        mGram.addTextChangedListener(mWatcher);
        mWon.addTextChangedListener(mWatcher);
        mWon2 = findViewById(R.id.won2);
        mPrice2 = findViewById(R.id.price2);
        mGram2.addTextChangedListener(mWatcher2);
        mWon2.addTextChangedListener(mWatcher2);

    }

    TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int gram, won;
            try {
                gram = Integer.parseInt(mGram.getText().toString());
            } catch (NumberFormatException e) {
                return;
            }
            try {
                won = Integer.parseInt(mWon.getText().toString());
            } catch (NumberFormatException e) {
                return;
            }
            float price = (float) won / gram;
            mPrice.setText(String.format("그램당 %.4f원",price));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    TextWatcher mWatcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int gram, won;
            try {
                gram = Integer.parseInt(mGram2.getText().toString());
            } catch (NumberFormatException e) {
                return;
            }
            try {
                won = Integer.parseInt(mWon2.getText().toString());
            } catch (NumberFormatException e) {
                return;
            }
            float price = (float) won / gram;
            mPrice2.setText(String.format("그램당 %.4f원",price));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
