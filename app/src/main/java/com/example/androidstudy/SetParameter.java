package com.example.androidstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class SetParameter extends Activity {
    Button mLeft;
    Button mRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setparameter);
        mLeft = (Button)findViewById(R.id.btnLeft);
        mRight = findViewById(R.id.btnRight);

        mLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setparam(3,1);
            }
        });
        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setparam(1,3);
            }
        });
    }
    void setparam(int left,int right) {
        LinearLayout.LayoutParams lparam = (LinearLayout.LayoutParams)mLeft.getLayoutParams();
        lparam.weight = left;
        mLeft.setLayoutParams(lparam);

        LinearLayout.LayoutParams rparam = (LinearLayout.LayoutParams)mRight.getLayoutParams();
        rparam.weight = right;
        mRight.setLayoutParams(rparam);
    }
}
