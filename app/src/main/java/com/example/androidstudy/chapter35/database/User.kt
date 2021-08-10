package com.example.androidstudy.chapter35.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = false)
    var id : String,
    @ColumnInfo(name = "pw")
    var pw : String
)

