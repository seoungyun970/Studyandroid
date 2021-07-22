package com.example.androidstudy.chapter11;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class SpinnerActivity extends Activity {
    ArrayAdapter<CharSequence> mSpinner;
    Boolean mInitSpinner = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        Spinner spin = findViewById(R.id.spinner);
        spin.setPrompt("나라를 고르세요.");

        mSpinner = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        mSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(mSpinner);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mInitSpinner == false) {
                    mInitSpinner = true;
                    return;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
