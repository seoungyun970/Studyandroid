package com.example.androidstudy.chapter34.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidstudy.chapter34.responseModel.UserData


@Database(entities = [UserData::class], version = 2, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDataDao : UserDataDao

    companion object {

        @Volatile
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context : Context) : UserDatabase {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
        }
    }
}