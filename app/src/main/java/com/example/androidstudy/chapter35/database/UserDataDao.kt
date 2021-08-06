package com.example.androidstudy.chapter35.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDataDao {

    @Insert
    fun insert(userData: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM user WHERE id = :key")
    fun get(key : Int) : User

    @Query("DELETE FROM user")
    fun clear()

    @Query("SELECT * FROM user ORDER BY id DESC LIMIT 1")
    fun get() : User?

}