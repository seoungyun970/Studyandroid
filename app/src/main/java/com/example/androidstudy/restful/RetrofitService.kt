package com.example.androidstudy.restful

import com.example.androidstudy.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {
    @POST(RequestUrl.LOGIN)
    fun login(
        @Body parameters : User
    ) : Call<UserModel>
}