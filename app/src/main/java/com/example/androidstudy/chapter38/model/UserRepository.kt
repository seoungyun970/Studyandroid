package com.example.androidstudy.chapter38.model

import com.example.androidstudy.chapter34.restful.RetrofitService
import com.example.androidstudy.chapter38.networking.Resource
import com.example.androidstudy.chapter38.networking.ResponseHandler
import com.example.androidstudy.chapter38.request.RequestUser
import com.google.android.gms.common.internal.Constants
import org.koin.dsl.module
import java.lang.Exception


val userModule = module {
    factory {
        UserRepository(get(),get())
    }
}

class UserRepository(private val retrofitService: RetrofitService,private val responseHandler: ResponseHandler) {
//    suspend fun getUser(requestUser : RequestUser) = retrofitService.withKoinLogin(requestUser)       //예외 처리 하기 전
    suspend fun getUser(requestUser : RequestUser) : Resource<KoinApiModel> {
        return try {
            val response = retrofitService.withKoinLogin(requestUser)
            return responseHandler.handleSuccess(response)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}