package com.example.androidstudy.chapter37;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class RxJavaActivity extends Activity {
//    @BindView(R.id.hello_word_salute)
//    TextView helloText;
//    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

//        ButterKnife.bind(this);
//
//        Observable.just("Hello! Please user this app responsibly!")
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        helloText.setText(s);
//                    }
//                });
    }
}
