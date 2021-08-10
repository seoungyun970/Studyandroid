package com.example.androidstudy.chapter35

import java.util.regex.Pattern

class CheckHelper {
    fun passWordCheck(pw: String): Boolean {
        val experssion = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}.$"
        //        val expression = "^[0-9]*$"     //숫자만
        val pattern = Pattern.compile(experssion, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(pw)
        return matcher.matches()
    }
}