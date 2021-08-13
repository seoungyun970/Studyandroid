package com.example.androidstudy.chapter38.application

import android.app.Application
import com.example.androidstudy.chapter38.koinActivityModule
import com.example.androidstudy.chapter38.model.userModule
import com.example.androidstudy.chapter38.networkModule
import com.example.androidstudy.chapter38.viewmodel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@KoinApplication)
            modules(listOf(viewModelModule, koinActivityModule,userModule,networkModule))
        }
    }
}