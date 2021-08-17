package com.example.androidstudy.chapter38.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androidstudy.chapter38.model.KoinUser
import com.example.androidstudy.chapter38.model.UserRepository
import com.example.androidstudy.chapter38.request.RequestUser
import org.koin.dsl.module


val viewModelModule = module {
    factory {
        ExampleViewModel(get())
    }
}

class ExampleViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _etId = MutableLiveData<String>()
    val etId : MutableLiveData<String>
        get() = _etId
    private val _etPw = MutableLiveData<String>()
    val etPw : MutableLiveData<String>
        get() = _etPw

//    val user: LiveData<KoinUser> = liveData {
//        emit(
//            userRepository.getUser(
//                RequestUser(
//                    "bhchoi_giosis",
//                    "12345",
//                    "N",
//                    "e505a053e5d7e990",
//                    "",
//                    "37.499756",
//                    "127.032454"
//                )
//            )
//        )
//    }


}