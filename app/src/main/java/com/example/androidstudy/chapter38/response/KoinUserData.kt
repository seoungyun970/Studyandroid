package com.example.androidstudy.chapter38.response

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class KoinUserData (
    @PrimaryKey(autoGenerate = false)
    var OpNo : String,
    @ColumnInfo(name = "OpId")
    var OpId : String,
    @ColumnInfo(name = "OpNm")
    var OpNm : String,
    @ColumnInfo(name = "OpType")
    var OpType : String,
    @ColumnInfo(name = "OfficeCode")
    var OfficeCode : String,
    @ColumnInfo(name = "OfficeName")
    var OfficeName : String,
    @ColumnInfo(name = "AgentCode")
    var AgentCode : String,
    @ColumnInfo(name = "AdminAuthYn")
    var AdminAuthYn : String,
    @ColumnInfo(name = "DsmAuthYn")
    var DsmAuthYn : String,
    @ColumnInfo(name = "CustNo")
    var CustNo : String,
    @ColumnInfo(name = "Email")
    var Email : String,
    @ColumnInfo(name = "DefaultYn")
    var DefaultYn : String,
    @ColumnInfo(name = "QLPSCustNo")
    var QLPSCustNo : String?,
    @ColumnInfo(name = "GroupNo")
    var GroupNo : String,
    @ColumnInfo(name = "AuthNo")
    var AuthNo : String,
    @ColumnInfo(name = "Version")
    var Version : String,
    @ColumnInfo(name = "SmsYn")
    var SmsYn : String,
    @ColumnInfo(name = "DeviceYn")
    var DeviceYn : String,
    @ColumnInfo(name = "EpEmail")
    var EpEmail : String,
    @ColumnInfo(name = "LoginMode")
    var LoginMode : String,
    @ColumnInfo(name = "VehicleCode")
    var VehicleCode : String,
    @ColumnInfo(name = "VehicleType")
    var VehicleType : String,
    @ColumnInfo(name = "PrevUsedDevice")
    var PrevUsedDevice : String,
    @ColumnInfo(name = "PrevLoginDriver")
    var PrevLoginDriver : String,
    @ColumnInfo(name = "QuickDriverYn")
    var QuickDriverYn : String,
    @ColumnInfo(name = "ZoneVendorType")
    var ZoneVendorType : String,
    @ColumnInfo(name = "Onoff")
    var Onoff : String,
    @ColumnInfo(name = "Suspendend")
    var Suspendend : String,
    @ColumnInfo(name = "VendorReportDisplayDriverYn")
    var VendorReportDisplayDriverYn : String,
)