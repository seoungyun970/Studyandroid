package com.example.androidstudy.chapter35

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudy.chapter35.database.LocalDB
import com.example.androidstudy.chapter35.viewmodel.UserViewModel
import com.example.androidstudy.R
import com.example.androidstudy.chapter35.SQLite.SQLiteHelper
import com.example.androidstudy.chapter35.SQLite.UserDBStructure
import com.example.androidstudy.databinding.ActivityLoginRoomBinding
import kotlinx.android.synthetic.main.activity_login_room.*
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginRoomBinding

    private val coroutineScopeList = ArrayList<CoroutineScope>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_room)

        init()
        setEvent()
    }

    private fun init() {
        val application = requireNotNull(this).application

        val dataSource = LocalDB.getInstance(application).userDataDao

        val viewModelFactory = UserViewModelFactory(dataSource, application)

        val userViewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.viewModel = userViewModel

    }

    private fun setEvent() {
        btn_login.setOnClickListener {
//            checkInformation(et_id.text.toString(), et_pw.text.toString())
            checkInformationSQLite(et_id.text.toString(), et_pw.text.toString())
        }
        btn_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        btn_delete.setOnClickListener {
            val scope = CoroutineScope(Dispatchers.IO)
            scope.launch {


                /** Room 사용
                 *
                 *
                 *
                 *
                 * */
                LocalDB.getInstance(this@LoginActivity).userDataDao.clears()
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginActivity, "DB Delete!!", Toast.LENGTH_SHORT).show()
                }

                /**SQLite 사용
                 *
                 *
                 *
                 *
                 *
                 * */

                if (!et_id.text.isNullOrEmpty()) {
                    val user =
                        SQLiteHelper.getInstance(this@LoginActivity, UserDBStructure.TABLE_NAME)
                    user.delete(et_id.text.toString())
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@LoginActivity, "DB Delete!!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Please check your id",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    private fun checkInformation(id: String?, pw: String?) {
        val scope = CoroutineScope(Dispatchers.IO)
        coroutineScopeList.add(scope)

        scope.launch {
            val user = id?.let {
                LocalDB.getInstance(this@LoginActivity).userDataDao.get(it)
            }
            val users = LocalDB.getInstance(this@LoginActivity).userDataDao.gets()
            println("users >>>" + users)

            if (user?.id.equals(id) && user?.pw.equals(pw)) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                }
            } else {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please Check your id and pw",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    @SuppressLint("LongLogTag")
    private fun checkInformationSQLite(id: String?, pw: String?) {
        val scope = CoroutineScope(Dispatchers.IO)
        coroutineScopeList.add(scope)

        scope.launch {
            val user = id?.let {
                SQLiteHelper.getInstance(this@LoginActivity, UserDBStructure.TABLE_NAME).search(it)
            }

            user?.moveToFirst()

            if (user != null) {
                //// db에서 가져온 id 값과 text의 id 값이 같으면
                if (user.moveToFirst()) {
                    if (user.getString(user.getColumnIndex("id")).equals(id) &&
                        user.getString(user.getColumnIndex("pw")).equals(pw)
                    ) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@LoginActivity,
                                "Please Check your id and pw",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Please Check your id and pw",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                Log.e("user?.moveToFirst()", user?.moveToFirst().toString())
                user.close()
                Log.e("user?.moveToFirst()>>>>>", user?.moveToFirst().toString())
            }

            Log.e("user?.moveToFirst()????????", user?.moveToFirst().toString())
        }
    }


    override fun onResume() {
        super.onResume()
        if (registerArrayListData() != null) {
            val information: ArrayList<String>? = registerArrayListData()
            if (information != null) {
                et_id.setText(information.get(0))
                et_pw.setText(information.get(1))
            }
        }
    }

    private fun registerArrayListData(): ArrayList<String>? {
        val information = intent.getStringArrayListExtra("information")
        return information
    }

    override fun onDestroy() {
        coroutineScopeList.forEach {
            if (it.isActive) {
                it.cancel()
            }
        }
        super.onDestroy()
    }
}