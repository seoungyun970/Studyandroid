package com.example.androidstudy.chapter38.model

import com.example.androidstudy.chapter34.restful.RetrofitService
import com.example.androidstudy.chapter38.request.RequestUser
import com.google.android.gms.common.internal.Constants
import org.koin.dsl.module


val userModule = module {
    factory { UserRepository(get()) }
}

class UserRepository(private val retrofitService: RetrofitService) {
    suspend fun getUser(requestUser : RequestUser) = retrofitService.withKoinLogin(requestUser)
}