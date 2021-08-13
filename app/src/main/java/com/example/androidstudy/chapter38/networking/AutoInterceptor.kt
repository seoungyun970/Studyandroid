package com.example.androidstudy.chapter38.networking

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class AutoInterceptor() : Interceptor {
    companion object {
        const val userAgent =
            "Android_QX.QUICK_2.5.8_191(GMKTV2_x_g_2_18YG9KOFH6zHDlyKzoDNI34XnCFqNLUDKcdCIXqgQ_g_3_;HMA-AL00;10;ko_KR)"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request().newBuilder()
            .addHeader("User-Agent", userAgent)
            .build()

        return chain.proceed(request)

    }
}

private fun loggingInterceptor(): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i(">>>>>>", message + "")
        }
    })

    // BASIC
    // HEADERS
    // BODY
    return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
}