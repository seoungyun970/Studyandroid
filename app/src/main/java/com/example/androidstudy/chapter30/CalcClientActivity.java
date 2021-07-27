package com.example.androidstudy.chapter30;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class CalcClientActivity extends Activity implements View.OnClickListener {
    CalcService mCalc;
    TextView mResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_client);

        mResult = findViewById(R.id.result);
        Button btn = findViewById(R.id.btnLCM);
        Button btn1 = findViewById(R.id.btnPrime);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLCM:
                int LCM = 0;
                try {
                    LCM = mCalc.getLCM(6, 8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mResult.setText("6과 8 의 최소 공배수 = " + LCM);
                break;
            case R.id.btnPrime:
                boolean prime = false;
                try {
                    prime = mCalc.isPrime(7);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                mResult.setText("7의 소수 여부 = " + prime);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this,CalcService.class);
        bindService(intent,srvConn,BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(srvConn);
    }

    ServiceConnection srvConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            mCalc = ((CalcService.CalcBinder)binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mCalc = null;
        }
    };
}
