package com.example.androidstudy.chapter38.networking

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor


private fun LoggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i(">>>>>>>>>>", message + "")
        }
    })

    // BASIC
    // HEADERS
    // BODY
    return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
}
