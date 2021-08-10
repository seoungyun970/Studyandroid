package com.example.androidstudy.chapter35

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.androidstudy.R
import com.example.androidstudy.chapter35.SQLite.SQLiteHelper
import com.example.androidstudy.chapter35.SQLite.UserDBStructure
import com.example.androidstudy.chapter35.database.LocalDB
import com.example.androidstudy.chapter35.database.User
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class RegisterActivity : Activity() {

    private val checker = CheckHelper()
    val scope = CoroutineScope(Dispatchers.IO)
    val sqLiteScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
//        setEvent()
        setSQLiteEvent()
    }

    private fun init() {
        btn_confirm.isEnabled = false
    }

    private fun setEvent() {

        btn_pw_check.setOnClickListener{
            val pw = et_pw.text.toString()
            val confirmPw = et_pw_check.text.toString()
            passWordCheck(pw,confirmPw)
            if (passWordCheck(pw,confirmPw)) {
                btn_confirm.isEnabled = true
            }
        }

        btn_confirm.setOnClickListener{
            val id = et_id.text.toString()
            val pw = et_pw.text.toString()

            val user = User(id,pw)
            scope.launch {
                LocalDB.getInstance(this@RegisterActivity).userDataDao.insert(user)
            }
            val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
            val userInformation : ArrayList<String> = arrayListOf(id,pw)
            intent.putStringArrayListExtra("information",userInformation)
            startActivity(intent)
            this@RegisterActivity.finish()
        }
    }

    private fun setSQLiteEvent() {

        btn_pw_check.setOnClickListener{
            val pw = et_pw.text.toString()
            val confirmPw = et_pw_check.text.toString()
            passWordCheck(pw,confirmPw)
            if (passWordCheck(pw,confirmPw)) {
                btn_confirm.isEnabled = true
            }
        }

        btn_confirm.setOnClickListener {
            val id = et_id.text.toString()
            val pw = et_pw.text.toString()

            var contentValues = ContentValues()
            contentValues.put("id",id)
            contentValues.put("pw",pw)

            sqLiteScope.launch {
                SQLiteHelper.getInstance(this@RegisterActivity,UserDBStructure.TABLE_NAME).insert(contentValues)
            }
            println("contentValues.toString() >> " + contentValues.toString())
            val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
            val userInformation : ArrayList<String> = arrayListOf(id,pw)
            intent.putStringArrayListExtra("information",userInformation)
            startActivity(intent)
            this@RegisterActivity.finish()
        }
    }
    private fun passWordCheck(pw : String, confirmPw : String) : Boolean{
        return if (pw.isEmpty()) {
            Toast.makeText(this,"please enter your password.",Toast.LENGTH_SHORT).show()
            false
        } else if (!checker.passWordCheck(pw)) {
            Toast.makeText(this,"It is not in password format",Toast.LENGTH_SHORT).show()
            false
        } else if (pw != confirmPw) {
            Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
            false
        }
        else {
            Toast.makeText(this,"Right!!",Toast.LENGTH_SHORT).show()
            return true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}