package com.example.androidstudy.responseModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserData(
    @SerializedName("OpNo") var OpNo : String,
    @SerializedName("OpId") var OpId : String,
    @SerializedName("OpNm") var OpNm : String,
    @SerializedName("OpType") var OpType : String,
    @SerializedName("OfficeCode") var OfficeCode : String,
    @SerializedName("OfficeName") var OfficeName : String,
    @SerializedName("AgentCode") var AgentCode : String,
    @SerializedName("AdminAuthYn") var AdminAuthYn : String,
    @SerializedName("DsmAuthYn") var DsmAuthYn : String,
    @SerializedName("CustNo") var CustNo : String,
    @SerializedName("Email") var Email : String,
    @SerializedName("DefaultYn") var DefaultYn : String,
    @SerializedName("QLPSCustNo") var QLPSCustNo : String,
    @SerializedName("GroupNo") var GroupNo : String,
    @SerializedName("AuthNo") var AuthNo : String,
    @SerializedName("Version") var Version : String,
    @SerializedName("SmsYn") var SmsYn : String,
    @SerializedName("DeviceYn") var DeviceYn : String,
    @SerializedName("EpEmail") var EpEmail : String,
    @SerializedName("LoginMode") var LoginMode : String,
    @SerializedName("VehicleCode") var VehicleCode : String,
    @SerializedName("VehicleType") var VehicleType : String,
    @SerializedName("PrevUsedDevice") var PrevUsedDevice : String,
    @SerializedName("PrevLoginDriver") var PrevLoginDriver : String,
    @SerializedName("QuickDriverYn") var QuickDriverYn : String,
    @SerializedName("ZoneVendorType") var ZoneVendorType : String,
    @SerializedName("Onoff") var Onoff : String,
    @SerializedName("Suspendend") var Suspendend : String,
    @SerializedName("VendorReportDisplayDriverYn") var VendorReportDisplayDriverYn : String,
)
