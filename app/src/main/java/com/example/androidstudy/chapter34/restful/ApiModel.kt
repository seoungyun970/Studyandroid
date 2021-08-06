package com.example.androidstudy.chapter34.restful

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class ApiModel (
    @SerializedName("ResultCode")
    var resultCode: Int = -1,

    @SerializedName("ResultMsg")
    var resultMsg: String? = null,

    @SerializedName("ResultObject")
    var resultObject: JsonElement? = null        // return data 오는 곳

)
