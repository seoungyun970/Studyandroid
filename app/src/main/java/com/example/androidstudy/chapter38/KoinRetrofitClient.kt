package com.example.androidstudy.chapter38

import com.example.androidstudy.chapter34.restful.RequestUrl.Companion.BASE_URL
import com.example.androidstudy.chapter34.restful.RetrofitService
import com.example.androidstudy.chapter38.networking.AutoInterceptor
import com.example.androidstudy.chapter38.networking.ResponseHandler
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
        provideOkHttpClient(get(),get())
    }
    factory {
        provideLoggingInterceptor()
    }

    factory {
        provideRetrofitService(get())
    }

    single {
        provideRetrofit(get())
    }

    factory {
        ResponseHandler()
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(autoInterceptor: AutoInterceptor,loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(autoInterceptor).addInterceptor(loggingInterceptor).build()
}

fun provideLoggingInterceptor() : HttpLoggingInterceptor {
    val logger = HttpLoggingInterceptor()
    logger.level = HttpLoggingInterceptor.Level.BODY
    return logger
}

fun provideRetrofitService(retrofit: Retrofit): RetrofitService =
    retrofit.create(RetrofitService::class.java)
