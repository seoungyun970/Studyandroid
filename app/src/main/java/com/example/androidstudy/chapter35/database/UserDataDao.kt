package com.example.androidstudy.chapter35.database

import androidx.room.*

@Dao
interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * FROM user WHERE id = :key")
    fun get(key : String) : User

    @Query("SELECT * FROM user WHERE id in (id) ORDER BY id ASC, id ASC")
    fun gets() : List<User>

    @Query("DELETE FROM user")
    fun clear()

    @Query("SELECT * FROM user ORDER BY id DESC LIMIT 1")
    fun get() : User?

}