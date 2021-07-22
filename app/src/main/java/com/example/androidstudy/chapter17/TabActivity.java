package com.example.androidstudy.chapter17;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends android.app.TabActivity {
    TabHost mTab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTab = getTabHost();

    }
}
