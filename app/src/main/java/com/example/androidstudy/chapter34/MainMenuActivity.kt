package com.example.androidstudy.chapter34

import android.app.Activity
import android.os.Bundle
import com.example.androidstudy.R
import com.example.androidstudy.chapter34.database.UserDataDao
import com.example.androidstudy.chapter34.database.UserDatabase
import kotlinx.android.synthetic.main.activity_main_manu.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainMenuActivity : Activity() {
    val data = UserDatabase.getInstance(this).userDataDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_manu)
        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch(Dispatchers.IO) {
            tv_information.text =  UserDatabase.getInstance(this@MainMenuActivity).userDataDao.get().toString()
            println("UserDatabase.getInstance(this@MainMenuActivity).userDataDao.get()?.AdminAuthYn>> " + UserDatabase.getInstance(this@MainMenuActivity).userDataDao.get()?.AdminAuthYn)

        }

    }
}