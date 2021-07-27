package com.example.androidstudy;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class GetProvider extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);
        // 위치 관리자 구함
        LocationManager locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //제공자 목록 구해서 출력
        List<String> arProvider = locMan.getProviders(false);
        String result = "";
        for (int i = 0; i < arProvider.size(); i++) {
            result += ("Provider " + " : " +arProvider.get(i) + "\n");
        }

        // 최적의 제공자 조사

        Criteria crit = new Criteria();
        //정확도
        crit.setAccuracy(Criteria.NO_REQUIREMENT);
        //전원 소비량
        crit.setPowerRequirement(Criteria.NO_REQUIREMENT);
        // 고도,높이 값을 얻어올지를 결정
        crit.setAltitudeRequired(false);
        // provider 기본 정보
        crit.setCostAllowed(false);
        String best = locMan.getBestProvider(crit,true);
        result += ("\nbest provider : " + best + "\n");

        result += LocationManager.GPS_PROVIDER + " : " +
                locMan.isProviderEnabled(LocationManager.GPS_PROVIDER) + "\n";

        result += LocationManager.NETWORK_PROVIDER + " : " +
                locMan.isProviderEnabled(LocationManager.NETWORK_PROVIDER) + "\n";

        TextView textView = findViewById(R.id.result);
        textView.setText(result);
    }
}
