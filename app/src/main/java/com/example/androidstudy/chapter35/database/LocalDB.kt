package com.example.androidstudy.chapter35.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class LocalDB : RoomDatabase() {
    abstract val userDataDao : UserDataDao

    companion object {

        @Volatile
        private var INSTANCE : LocalDB? = null
        fun getInstance(context: Context) : LocalDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDB::class.java,
                        "local.db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}