package com.example.androidstudy.restful

import android.content.ContentValues.TAG
import android.util.Log
import com.example.androidstudy.restful.RequestUrl.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private var instance : Retrofit? = null

    fun getInstance() : Retrofit {
        if(instance == null) {
            val interceptor = HttpLoggingInterceptor()
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient()
            client.newBuilder().addInterceptor(interceptor).build()

            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance!!
    }

    private fun getRequestHeader() : OkHttpClient {
        val httpClient = OkHttpClient()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
//            .connectTimeout(70,TimeUnit.SECONDS)
//            .readTimeout(30,TimeUnit.SECONDS)
        return httpClient
    }
    private fun loggingInterceptor() : HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.i(TAG, message + "")
            }
        })
        return interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}