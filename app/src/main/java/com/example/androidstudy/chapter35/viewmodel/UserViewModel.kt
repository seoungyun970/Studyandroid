package com.example.androidstudy.chapter35.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidstudy.chapter35.database.User
import com.example.androidstudy.chapter35.database.UserDataDao


class UserViewModel(val database: UserDataDao, application: Application) : AndroidViewModel(application) {

    private val data = MutableLiveData<User?>()
    fun loginClick() {

    }

    fun registerClick() {

    }

    fun pwCheck() {

    }

}