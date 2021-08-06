package com.example.androidstudy.chapter35

import android.app.Activity
import android.os.Bundle
import com.example.androidstudy.R

class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    private fun passWordCheck(pw : String, confirmPw : String) : Boolean{
        return if (pw.isEmpty()) {
            false
        } else {
            return false
        }
    }
}