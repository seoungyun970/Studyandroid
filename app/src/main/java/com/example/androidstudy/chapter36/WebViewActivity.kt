package com.example.androidstudy.chapter36

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudy.R
import com.example.androidstudy.chapter36.bridge.WebBridge
import kotlinx.android.synthetic.main.activity_webview.*
import java.net.URLEncoder


class WebViewActivity : AppCompatActivity() ,WebBridge.BridgeListener{

    private val bridge = WebBridge()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setEvent()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun init() {
        setContentView(R.layout.activity_webview)
        web_View.webViewClient = WebViewClient()
        web_View.webChromeClient = WebChromeClient()        // WebChromeClient 하지 않으면 javascript alert 호출 x
        web_View.loadUrl("file:///android_asset/Untitled.html")
//        val string = "file:///android_asset/Untitled.html"
////        web_View.loadDataWithBaseURL("","","file:///android_asset/Untitled.html","UTF-8","")
//        web_View.loadData(string,"text/html; charset=UTF-8",null)
        webViewSetting()

    }

    private fun webViewSetting() {
        web_View.settings.apply {
            javaScriptEnabled = true        // 웹페이지 자바스크립트 허용
            domStorageEnabled = true        // 로컬저장소 허용
            setSupportMultipleWindows(true) // 새창 띄우기 허용
        }
        web_View.addJavascriptInterface(bridge,"java")      //  addJavascriptInterface("BridgeClass 명 ", "호출에 사용할 name")
        bridge.setListener(this)
    }

    private fun setEvent() {
        btn.setOnClickListener{
//            web_View.loadUrl("javascript:exam_script.showWebView(" + et_num.text.toString() + ")")      //''생략하면 한글 특수문자 사용x
            web_View.loadUrl("javascript:exam_script.showWebView('" + et_num.text.toString() + "');")   // 숫자,한글,특수문자 가능
        }
    }

    override fun showToast(string: String) {
        val handler = Handler(Looper.getMainLooper())
        handler.post{
            Toast.makeText(this,string,Toast.LENGTH_SHORT).show()
        }
    }

}