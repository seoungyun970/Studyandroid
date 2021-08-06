package com.example.androidstudy.chapter34.responseModel

import com.google.gson.annotations.SerializedName

data class JsonArrayData(
    @SerializedName("driver_id") var driver_id : String,
    @SerializedName("vendor_cd") var vendor_cd : String,
    @SerializedName("date") var date : String,
    @SerializedName("onoff") var onoff : String,
    @SerializedName("memo") var memo : String,
    @SerializedName("reg_id") var reg_id : String,
    @SerializedName("reg_dt") var reg_dt : String,
    @SerializedName("chg_id") var chg_id : String,
    @SerializedName("chg_dt") var chg_dt : String,
    @SerializedName("roster_code") var roster_code : String,
    @SerializedName("job_count") var job_count : String,
    @SerializedName("total_slot_use_yn") var total_slot_use_yn : String,
)
