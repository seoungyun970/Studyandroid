package com.example.androidstudy.chapter38

import com.example.androidstudy.chapter34.model.User
import com.example.androidstudy.chapter34.model.WorkSchedule
import com.example.androidstudy.chapter34.restful.ApiModel
import com.example.androidstudy.chapter34.restful.RetrofitService
import com.example.androidstudy.chapter38.model.KoinUser
import com.example.androidstudy.chapter38.request.RequestUser
import retrofit2.Call

class MyRetrofitService(val myRepository: MyRepository) : RetrofitService {
    override fun login(parameters: User): Call<ApiModel> {
        TODO("Not yet implemented")
    }

    override fun jsonArrayCheck(parameters: WorkSchedule): Call<ApiModel> {
        TODO("Not yet implemented")
    }

    override suspend fun withKoinLogin(parameters: RequestUser): KoinUser {
        TODO("Not yet implemented")
    }


}