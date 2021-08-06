package com.example.androidstudy.chapter34.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.androidstudy.chapter34.model.User
import com.example.androidstudy.chapter34.responseModel.UserData

@Dao
interface UserDataDao {

    @Insert
    fun insert(userData: UserData)

    @Update
    fun update(userData: UserData)

    @Query("SELECT * FROM user_data WHERE OpNo = :key")
    fun get(key : Int) : UserData

    @Query("DELETE FROM user_data")
    fun clear()

    @Query("SELECT * FROM user_data ORDER BY OpNo DESC LIMIT 1")
    fun get() : UserData?

/*    @Query("SELECT * FROM user_data ORDER BY OpNo DESC")
    fun getAllUsers() : LiveData<List<UserData>>*/
}