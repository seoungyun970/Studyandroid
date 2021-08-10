package com.example.androidstudy.chapter35.SQLite

import android.provider.BaseColumns
import com.example.androidstudy.chapter35.database.User

object UserDBStructure : BaseColumns {
    val TABLE_NAME = "users"
    val COLUMN_ID = "id"
    val COLUMN_PW = "pw"

    val CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "$COLUMN_ID TEXT NOT NULL, " +
            "$COLUMN_PW TEXT NOT NULL);"

    val DROP_TABLE_USER = "DROP TABLE IF EXISTS $TABLE_NAME"


}