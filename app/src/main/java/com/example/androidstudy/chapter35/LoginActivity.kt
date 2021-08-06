package com.example.androidstudy.chapter35

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.chapter35.database.LocalDB
import com.example.androidstudy.chapter35.viewmodel.UserViewModel
import com.example.androidstudy.R
import com.example.androidstudy.databinding.ActivityLoginRoomBinding
import kotlinx.android.synthetic.main.activity_login_room.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login_room)

        init()
        setEvent()
    }

    private fun init() {
        val application = requireNotNull(this).application

        val dataSource = LocalDB.getInstance(application).userDataDao

        val viewModelFactory = UserViewModelFactory(dataSource,application)

        val userViewModel = ViewModelProvider(this,viewModelFactory).get(UserViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.viewModel = userViewModel

    }

    private fun setEvent() {
        btn_login.setOnClickListener{

        }
        btn_register.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }


}