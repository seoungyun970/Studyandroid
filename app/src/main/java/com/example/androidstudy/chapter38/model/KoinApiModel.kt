package com.example.androidstudy.chapter38.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class KoinApiModel(
    @SerializedName("ResultCode")
    var resultCode: Int = -1,

    @SerializedName("ResultMsg")
    var resultMsg: String? = null,

    @SerializedName("ResultObject")
    var resultObject: JsonElement        // return data 오는 곳
)
