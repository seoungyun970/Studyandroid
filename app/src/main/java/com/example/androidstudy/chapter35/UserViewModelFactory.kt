package com.example.androidstudy.chapter35

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.chapter35.database.UserDataDao
import com.example.androidstudy.chapter35.viewmodel.UserViewModel
import java.lang.IllegalArgumentException

class UserViewModelFactory(private val datasource : UserDataDao ,private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(datasource,application) as T
        } else {
            throw IllegalArgumentException("UnKnown ViewModel Class")
        }
    }

}