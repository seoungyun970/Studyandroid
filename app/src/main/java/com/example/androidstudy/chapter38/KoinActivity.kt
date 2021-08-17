package com.example.androidstudy.chapter38

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.androidstudy.R
import com.example.androidstudy.chapter38.model.UserRepository
import com.example.androidstudy.chapter38.networking.Status
import com.example.androidstudy.chapter38.request.RequestUser
import com.example.androidstudy.chapter38.response.KoinUserData
import com.example.androidstudy.chapter38.viewmodel.ExampleViewModel
import com.example.androidstudy.databinding.ActivityKoinBinding
import com.google.gson.Gson
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.activity_koin.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val koinActivityModule = module {
    factory {
        KoinActivity()
    }
}

class KoinActivity : AppCompatActivity(), View.OnClickListener {
    private val exampleViewModel: ExampleViewModel by viewModel()
    private val scope = CoroutineScope(Dispatchers.IO)
    private lateinit var binding: ActivityKoinBinding
    private val userRepository : UserRepository by inject()
//    @SuppressLint("SetTextI18n")
//    private val observer = Observer<KoinUser> {
//        binding.userData.text =
//            "OpNo : " + it.resultObject.OpNo + "\nOpId : " + it.resultObject.OpId +
//                    "\nprevUsedDevice : " + it.resultObject.PrevUsedDevice +
//                    "\nOfficeName : " + it.resultObject.OfficeName
//        println(">>>>>>>>>>>" + it.resultObject.AdminAuthYn)
//        println(">>>>>>>>>>>" + it.resultObject.OpNo)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_koin)

        btn_login.setOnClickListener(this)
    }

//    private fun init() {
//        binding.setLifecycleOwner(this)
//    }

    override fun onClick(v: View?) {
//        exampleViewModel.user.observe(this, observer)

        scope.launch {
            val response = userRepository.getUser(
                RequestUser(tv_id.text.toString(),
                    tv_pw.text.toString(),
                    "N",
                    "e505a053e5d7e990",
                    "",
                    "37.499756",
                    "127.032454")
            )

            if (response.data?.resultCode == -106) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@KoinActivity,response.data.resultMsg,Toast.LENGTH_SHORT).show()
                }
            } else if (response.data?.resultCode == -105) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@KoinActivity,response.data.resultMsg,Toast.LENGTH_SHORT).show()
                }
            } else if (response.data?.resultCode == 0) {
                response.data?.let {
                    val data = Gson().fromJson(it.resultObject,KoinUserData::class.java)
                    println("data.OpNo >> " + data.AdminAuthYn)
                    println("data.OpNo >> " + data.OpNo)
                }
            }


//            println("response.status >> " +  response.status)
//            println("response.message >> " +  response.message)
//            println("response.data >> " +  response.data)
//            println("response.data?.resultCode >> " +  response.data?.resultCode)
//            println("response.data?.resultMsg >> " +  response.data?.resultMsg)

//            if (data != null) {
//                println("data.AdminAuthYn>>> " + data.AdminAuthYn)
//                println("data.AgentCode>>>" + data.AgentCode)
//                println("data.OpNo>>>" + data.OpNo)
//            }
        }

    }

}