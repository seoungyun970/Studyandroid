package com.example.androidstudy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class GeoCodingActivity extends Activity implements View.OnClickListener {
    LocationManager mLocMan;
    Geocoder mCoder;
    TextView mResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geo_coding);

        mResult = findViewById(R.id.result);
        mCoder = new Geocoder(this);

        Button btn1 = findViewById(R.id.convert);
        Button btn2 = findViewById(R.id.convert2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.convert:
                List<Address> addr;
                String slat = ((EditText)findViewById(R.id.lat)).getText().toString();
                String slon = ((EditText)findViewById(R.id.lon)).getText().toString();

                try {
                    addr = mCoder.getFromLocation(Double.parseDouble(slat),Double.parseDouble(slon),5);
                }catch (Exception e) {
                    mResult.setText("IO Error : " + e.getMessage());
                    return;
                }
                if (addr ==null) {
                    mResult.setText("no result");
                    return;
                }

                mResult.setText("개수 = " +addr.size() + "\n" + addr.get(0).toString());
                break;
            case R.id.convert2:
                List<Address> addr2;
                String saddr = ((EditText)findViewById(R.id.address)).getText().toString();
                Log.d(">>>>> ", saddr);
                try {
                    addr2 = mCoder.getFromLocationName(saddr,5);
                } catch (Exception e) {
                    mResult.setText("IO Error : " + e.getMessage());
                    return;
                }
                if (addr2 == null || addr2.isEmpty()) {
                    mResult.setText("no Result");
                    return;
                }
                mResult.setText("개수 : " +addr2.size() + "\n" +addr2.get(0).toString());
                break;
        }

    }

}
