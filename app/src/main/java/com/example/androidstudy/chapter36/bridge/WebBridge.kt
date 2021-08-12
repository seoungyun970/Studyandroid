package com.example.androidstudy.chapter36.bridge

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.webkit.JavascriptInterface
import android.widget.TextView
import android.widget.Toast

class WebBridge {

    private var callback : BridgeListener? = null

    fun setListener(listener : BridgeListener) {
        callback = listener
    }

    // javaScript에서 동작하는 함수
    @JavascriptInterface
    fun showToast(string : String) {
        callback?.showToast(string)
    }

    interface BridgeListener {
        fun showToast(string : String)
    }

}