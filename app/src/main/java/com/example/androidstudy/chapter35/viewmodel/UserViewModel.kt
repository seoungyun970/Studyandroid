package com.example.androidstudy.chapter35.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidstudy.chapter35.CheckHelper
import com.example.androidstudy.chapter35.database.User
import com.example.androidstudy.chapter35.database.UserDataDao


class UserViewModel(val database: UserDataDao, application: Application) :
    AndroidViewModel(application) {
    private val checker = CheckHelper()

    private val data = MutableLiveData<User?>()

    private val _pwData = MutableLiveData<String>()
    val pwData : LiveData<String>
        get() =_pwData

    private val _pwConfirm = MutableLiveData<Boolean>()
    val pwConfirm : LiveData<Boolean>
        get() = _pwConfirm

    private val _etpw = MutableLiveData<String>()
    val etpw : MutableLiveData<String>
        get() = _etpw


    fun loginClick() {

    }

    fun registerClick() {

    }
    fun confirm() {
        _pwConfirm.value = pwConfirm.value
    }

    fun btnConfirm() : MutableLiveData<Boolean> {
        return _pwConfirm
    }

    fun pwCheck() {
        _pwData.value = pwData.toString()
    }

    fun pwData() : MutableLiveData<String> {
        return _pwData
    }

    fun pwGet() {
        _etpw.value = etpw.toString()
    }

    fun pwGetMutable() : MutableLiveData<String> {
        return _etpw
    }


    private fun passWordCheck(pw : String, confirmPw : String) : Boolean{
        return if (pw.isEmpty()) {
            Toast.makeText(getApplication(),"please enter your password.", Toast.LENGTH_SHORT).show()
            false
        } else if (!checker.passWordCheck(pw)) {
            Toast.makeText(getApplication(),"It is not in password format", Toast.LENGTH_SHORT).show()
            false
        } else if (pw != confirmPw) {
            Toast.makeText(getApplication(),"Passwords do not match", Toast.LENGTH_SHORT).show()
            false
        }
        else {
            Toast.makeText(getApplication(),"Right!!", Toast.LENGTH_SHORT).show()
            return true
        }
    }


}