package com.example.androidstudy.chapter35

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.R
import com.example.androidstudy.chapter35.SQLite.SQLiteHelper
import com.example.androidstudy.chapter35.SQLite.UserDBStructure
import com.example.androidstudy.chapter35.database.LocalDB
import com.example.androidstudy.chapter35.database.User
import com.example.androidstudy.chapter35.viewmodel.UserViewModel
import com.example.androidstudy.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private val checker = CheckHelper()
    val scope = CoroutineScope(Dispatchers.IO)
    val sqLiteScope = CoroutineScope(Dispatchers.IO)

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userViewModel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        init()
//        setEvent()
        setSQLiteEvent()
        userViewModel.pwData().observe(this, {

        })
        userViewModel.btnConfirm().observe(this,{

        })
        userViewModel.etpw.observe(this,{
            val pw = et_pw.text.toString()
            val confirmPw = et_pw_check.text.toString()
            passWordCheck(pw,confirmPw)
            if (passWordCheck(pw,confirmPw)) {
                btn_confirm.isEnabled = true
            }
        })
//        userViewModel.pwGetMutable().observe(this,{
//
//        })
    }

    private fun init() {
        btn_confirm.isEnabled = false

        val application = requireNotNull(this).application

        val dataSource = LocalDB.getInstance(application).userDataDao

        val viewModelFactory = UserViewModelFactory(dataSource, application)

        userViewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.viewModel = userViewModel

    }









    /**Room
     *
     *
     *
     * */

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


    /**SQLite
     *
     *
     *
     * */

    private fun setSQLiteEvent() {

        btn_pw_check.setOnClickListener{
//            val pw = et_pw.text.toString()
//            val confirmPw = et_pw_check.text.toString()
//            passWordCheck(pw,confirmPw)
//            if (passWordCheck(pw,confirmPw)) {
//                btn_confirm.isEnabled = true
//            }
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
            tv_id_format.setText("please enter your password.")
//            Toast.makeText(this,"please enter your password.",Toast.LENGTH_SHORT).show()
            false
        } else if (!checker.passWordCheck(pw)) {
            tv_id_format.setText("It is not in password format")
//            Toast.makeText(this,"It is not in password format",Toast.LENGTH_SHORT).show()
            false
        } else if (pw != confirmPw) {
            tv_id_format.setText("Passwords do not match")
//            Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show()
            false
        }
        else {
            tv_id_format.setText("")
//            Toast.makeText(this,"Right!!",Toast.LENGTH_SHORT).show()
            return true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}