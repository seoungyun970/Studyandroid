package com.example.androidstudy.chapter35.SQLite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import okio.ByteString.Companion.encode

class SQLiteHelper(
    context: Context,
    name: String,
) : SQLiteOpenHelper(context, name, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_VERSION = 1
        var INSTANCE: SQLiteHelper? = null
        fun getInstance(context: Context, name: String): SQLiteHelper {

            if (INSTANCE == null) {
                INSTANCE = SQLiteHelper(context, name)
            }
            return INSTANCE!!
        }
    }

    fun insert(values: ContentValues): Long {
        var db: SQLiteDatabase = writableDatabase
        return db.insert(UserDBStructure.TABLE_NAME, null, values)
    }

    @SuppressLint("Recycle")
    fun searchs(): Cursor {
        val db: SQLiteDatabase = writableDatabase
        val query: String = "SELECT * FROM " + UserDBStructure.TABLE_NAME
        val data: Cursor = db.rawQuery(query, null)
        return data
    }

    fun search(key: String): Cursor {
        var db: SQLiteDatabase = writableDatabase
//        val query : String = "SELECT * FROM " + UserDBStructure.TABLE_NAME + " WHERE ${UserDBStructure.COLUMN_ID} = $key"         //need to use apostrophe(') in Where clause checking..
        val query: String =
            "SELECT * FROM " + UserDBStructure.TABLE_NAME + " WHERE ${UserDBStructure.COLUMN_ID} = '" + key + "'"
        Log.e("query", query)
        val data: Cursor = db.rawQuery(query, null)
        Log.e("data", data.toString())
        return data
    }

    fun delete(key: String) {
        var db: SQLiteDatabase = readableDatabase
        val query: String =
            "DELETE FROM " + UserDBStructure.TABLE_NAME + " WHERE ${UserDBStructure.COLUMN_ID} = '" + key + "'"
        Log.e("query", query)
        db.execSQL(query)
    }

    fun deleteAll() {
        var db: SQLiteDatabase = readableDatabase

        val query: String =
            "DELETE * FROM " + UserDBStructure.TABLE_NAME

        db.execSQL(query)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        var db: SQLiteDatabase = readableDatabase
        return db.update(UserDBStructure.TABLE_NAME, values, whereClause, whereArgs)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(UserDBStructure.CREATE_TABLE_USER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(UserDBStructure.DROP_TABLE_USER)
        onCreate(db)
    }


}