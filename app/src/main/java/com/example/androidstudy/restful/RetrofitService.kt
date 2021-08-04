package com.example.androidstudy.restful

import com.example.androidstudy.model.WorkSchedule
import com.example.androidstudy.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST(RequestUrl.LOGIN)
    suspend fun login(
        @Body parameters : User
    ) : ApiModel

    @POST(RequestUrl.JSONARRAYCHECK)
    fun jsonArrayCheck(
        @Body parameters: WorkSchedule
    ) : Call<ApiModel>


/*    @POST(RequestUrl.LOGIN)
    suspend fun suspendLogin(
        @Body parameters : User
    ): Call<ApiModel>*/
}