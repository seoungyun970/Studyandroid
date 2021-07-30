package com.example.androidstudy.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field
import java.io.Serializable

data class User(
    @SerializedName("login_id") var login_id: String,
    @SerializedName("password") var password: String,
    @SerializedName("admin_yn") var admin_yn: String,
    @SerializedName("referer") var referer: String,
    @SerializedName("vehicle") var vehicle: String,
    @SerializedName("latitude") var latitude: String,
    @SerializedName("longitude") var longitude: String,
    @SerializedName("chanel") var chanel: String = "QUICK",
    @SerializedName("ip") var ip: String = "",
    @SerializedName("app_id") var app_id: String = "QUICK",
    @SerializedName("nation_cd") var nation_cd: String = "SG",
)
