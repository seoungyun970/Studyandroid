package com.example.androidstudy.chapter34.model

import com.google.gson.annotations.SerializedName

data class WorkSchedule (
    @SerializedName("s_date") var s_date: String,
    @SerializedName("e_date") var  e_date: String,
    @SerializedName("driver_id") var driver_id: String = "bhchoi_giosis",
    @SerializedName("vendor_cd") var vendor_cd: String = "0000",
    @SerializedName("nation_cd") var nation_cd: String = "SG",
)
