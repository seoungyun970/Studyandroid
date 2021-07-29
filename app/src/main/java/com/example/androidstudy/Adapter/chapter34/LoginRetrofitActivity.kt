package com.example.androidstudy.Adapter.chapter34

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.androidstudy.R
import com.example.androidstudy.listener.SingleClickListener
import com.example.androidstudy.model.User
import com.example.androidstudy.restful.RetrofitClient
import com.example.androidstudy.restful.RetrofitService
import com.example.androidstudy.restful.UserModel
import kotlinx.android.synthetic.main.activity_login_retrofit.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginRetrofitActivity : Activity(){
    lateinit var retrofit :Retrofit
    lateinit var IApi : RetrofitService
    private val coroutineScopeList = ArrayList<CoroutineScope>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_retrofit)

        retrofit = RetrofitClient.getInstance()

        IApi = retrofit.create(RetrofitService::class.java)

        val clickListener = SingleClickListener {
            checkLogin(tv_id.text.toString(),tv_pw.text.toString())
//            checkLoginAsynchronous(tv_id.text.toString(),tv_pw.text.toString())
            println("btn_login.click")
        }

        btn_login.setOnClickListener(clickListener)
    }




    /**
     * 동기
     *
     *
     * */
    @SuppressLint("LongLogTag")
    private fun checkLogin(id : String, pw : String) {

        val checkLoginCoroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScopeList.add(checkLoginCoroutineScope)

        checkLoginCoroutineScope.launch {
            try {
                var req = User(id,pw,"N","e505a053e5d7e99","","37.499756","127.032454")

                val response = IApi.login(req).execute()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@LoginRetrofitActivity,"Login Success",Toast.LENGTH_SHORT).show()
                    }
                    Log.d("response.isSuccessful >>>>" ,response.isSuccessful.toString())
                    Log.d("response code >>>",response.code().toString())
                    val userData = response.body()

                    userData?.let {
                        it.resultObject
                        Log.d("it.resultObject >>>" , it.resultObject.toString())
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@LoginRetrofitActivity,response.code(),Toast.LENGTH_SHORT).show()
                        Log.d("response.code() >>>>>" ,response.code().toString())
                        when (response.code()) {

                        }
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@LoginRetrofitActivity,e.message,Toast.LENGTH_SHORT).show()
                    Log.d("e.toString() >>>>>>>>",e.toString())
                }
            }
        }
    }

    /**비동기
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * */
    private fun checkLoginAsynchronous(id : String, pw : String) {
        val checkLoginCoroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScopeList.add(checkLoginCoroutineScope)
        checkLoginCoroutineScope.launch {
            var req = User(id,pw,"N","e505a053e5d7e99","","37.499756","127.032454")
            IApi.login(req).enqueue(object : Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    Log.d("onResponse >>> ", response.body().toString())


                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("onFailure msg >>>", t.message.toString())
                }

            })
        }
    }

    override fun onDestroy() {
        coroutineScopeList.forEach{
            if(it.isActive) {
                it.cancel()
            }
        }
        super.onDestroy()
    }
}