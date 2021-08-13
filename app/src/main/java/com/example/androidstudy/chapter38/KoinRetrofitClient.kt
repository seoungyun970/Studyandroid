package com.example.androidstudy.chapter38

import com.example.androidstudy.chapter34.restful.RequestUrl.Companion.BASE_URL
import com.example.androidstudy.chapter34.restful.RetrofitService
import com.example.androidstudy.chapter38.networking.AutoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    factory {
        AutoInterceptor()
    }

    factory {
        provideOkHttpClient(get())
    }

    factory {
        provideRetrofitService(get())
    }

    single {
        provideRetrofit(get())
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(autoInterceptor: AutoInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(autoInterceptor).build()
}

fun provideRetrofitService(retrofit: Retrofit): RetrofitService =
    retrofit.create(RetrofitService::class.java)
