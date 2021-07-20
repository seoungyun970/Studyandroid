package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class IfMissing  extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ifmissing);

        Button button = findViewById(R.id.btnToggle);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ImageView img = findViewById(R.id.icon);
        if (img.getVisibility() == View.VISIBLE) {
           img.setVisibility(View.GONE);
        } else {
            img.setVisibility(View.VISIBLE);
        }
    }
}
