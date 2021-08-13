package com.example.androidstudy.chapter38

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.R
import com.example.androidstudy.chapter38.model.KoinUser
import com.example.androidstudy.chapter38.model.UserRepository
import com.example.androidstudy.chapter38.request.RequestUser
import com.example.androidstudy.chapter38.viewmodel.ExampleViewModel
import com.example.androidstudy.databinding.ActivityKoinBinding
import kotlinx.android.synthetic.main.activity_koin.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.bind
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

    @SuppressLint("SetTextI18n")
    private val observer = Observer<KoinUser> {
        binding.userData.text =
            "OpNo : " + it.resultObject.OpNo + "\nOpId : " + it.resultObject.OpId +
                    "\nprevUsedDevice : " + it.resultObject.PrevUsedDevice +
                    "\nOfficeName : " + it.resultObject.OfficeName
        println(">>>>>>>>>>>" + it.resultObject.AdminAuthYn)
        println(">>>>>>>>>>>" + it.resultObject.OpNo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_koin)

        btn_login.setOnClickListener(this)
        exampleViewModel
    }

    private fun init() {
        binding.setLifecycleOwner(this)
    }

    override fun onClick(v: View?) {
        exampleViewModel.user.observe(this, observer)
    }

}