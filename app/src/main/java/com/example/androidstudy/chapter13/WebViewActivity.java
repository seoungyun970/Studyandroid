package com.example.androidstudy.chapter13;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class WebViewActivity extends Activity implements View.OnClickListener {
    WebView mWeb;
    String url = "https://www.naver.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        mWeb = findViewById(R.id.web);
        mWeb.setWebViewClient(new WebViewClient());
        WebSettings set = mWeb.getSettings();
        set.setJavaScriptEnabled(true);
        set.setJavaScriptEnabled(true);
        mWeb.loadUrl(url);

        Button btn = findViewById(R.id.btn_go);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText addr = findViewById(R.id.address);
        String url = addr.getText().toString();
        mWeb.loadUrl(url);
    }
}
