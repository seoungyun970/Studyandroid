package com.example.androidstudy.chapter34.restful

import com.example.androidstudy.chapter34.model.WorkSchedule
import com.example.androidstudy.chapter34.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST(RequestUrl.LOGIN)
    fun login(
        @Body parameters : User
    ) : Call<ApiModel>

    @POST(RequestUrl.JSONARRAYCHECK)
    fun jsonArrayCheck(
        @Body parameters: WorkSchedule
    ) : Call<ApiModel>


/*    @POST(RequestUrl.LOGIN)
    suspend fun suspendLogin(
        @Body parameters : User
    ): Call<ApiModel>*/
}