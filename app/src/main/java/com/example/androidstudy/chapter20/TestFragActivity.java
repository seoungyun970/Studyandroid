package com.example.androidstudy.chapter20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.androidstudy.R;

import org.jetbrains.annotations.NotNull;

public class TestFragActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_fragment);

        viewPager = findViewById(R.id.pager);
        Button btnFirst = findViewById(R.id.btn_first);
        Button btnSecond = findViewById(R.id.btn_second);
        Button btnThird = findViewById(R.id.btn_third);

        viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        View.OnClickListener movePageListener = v -> {
            int tag = (int) v.getTag();
            viewPager.setCurrentItem(tag);
        };
        btnFirst.setOnClickListener(movePageListener);
        btnFirst.setTag(0);
        btnSecond.setOnClickListener(movePageListener);
        btnSecond.setTag(1);
        btnThird.setOnClickListener(movePageListener);
        btnThird.setTag(2);
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {

        public pagerAdapter(@NonNull @NotNull FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
