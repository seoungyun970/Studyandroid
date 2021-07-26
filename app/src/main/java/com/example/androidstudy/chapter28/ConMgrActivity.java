package com.example.androidstudy.chapter28;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class ConMgrActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conmgr);

        TextView result = findViewById(R.id.result);
        String sResult = "";
        ConnectivityManager mgr = ((ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE));
        NetworkInfo[] ani = mgr.getAllNetworkInfo();
        for (NetworkInfo n : ani) {
            sResult += (n.toString() + "\n\n");
        }
        NetworkInfo ni = mgr.getActiveNetworkInfo();
        if (ni != null) {
            sResult += ("Active : \n" + ni.toString() + "\n");
            result.setText(sResult);
        }
    }
}
