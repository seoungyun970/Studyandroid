package com.example.androidstudy.restful

import com.example.androidstudy.restful.RequestUrl.Companion.BASE_URL
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var instance : Retrofit? = null

    fun getInstance() : Retrofit {
        if(instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getRequestHeader())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return instance!!
    }

    private fun getRequestHeader() : OkHttpClient {
        val httpClient = OkHttpClient()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//            .connectTimeout(70,TimeUnit.SECONDS)
//            .readTimeout(30,TimeUnit.SECONDS)
        return httpClient
    }
}