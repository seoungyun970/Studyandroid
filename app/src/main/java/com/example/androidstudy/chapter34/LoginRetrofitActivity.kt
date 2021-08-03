package com.example.androidstudy.chapter34

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.androidstudy.R
import com.example.androidstudy.listener.SingleClickListener
import com.example.androidstudy.model.User
import com.example.androidstudy.model.WorkSchedule
import com.example.androidstudy.responseModel.JsonArrayData
import com.example.androidstudy.responseModel.UserData
import com.example.androidstudy.restful.ApiModel
import com.example.androidstudy.restful.RetrofitClient
import com.example.androidstudy.restful.RetrofitService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_login_retrofit.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class LoginRetrofitActivity : Activity(), View.OnClickListener {

    lateinit var IApi: RetrofitService
    private val coroutineScopeList = ArrayList<CoroutineScope>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_retrofit)

        IApi = RetrofitClient.getInstance().create(RetrofitService::class.java)

        val clickListener = SingleClickListener {
//            checkLogin(tv_id.text.toString(), tv_pw.text.toString())
//            checkLoginAsynchronous(tv_id.text.toString(),tv_pw.text.toString())
            checkSuspendLogin(tv_id.text.toString(),tv_pw.text.toString())
        }

        btn_login.setOnClickListener(clickListener)
        btn_jsonArray.setOnClickListener(this)
    }

    /**
     * 동기
     *
     *
     * */
    @SuppressLint("LongLogTag")
    private fun checkLogin(id: String, pw: String) {

        val checkLoginCoroutineScope = CoroutineScope(Dispatchers.IO)
        // Dispatchers.IO 는 네트워크 혹은 내부 DB 접근 등 백그라운드에서 필요한 작업을 수행 할때 사용
        coroutineScopeList.add(checkLoginCoroutineScope)

        checkLoginCoroutineScope.launch {
            try {
                var req = User(
                    id, pw, "N", "e505a053e5d7e99", "",
                    "37.499756", "127.032454"
                )

                val response = IApi.login(req).execute()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        // Dispatchers.Main 은 말그대로 메인쓰레드에 대한 Context 이며 UI 갱신이나 Toast 등의 View 작업에 사용


                        Toast.makeText(
                            this@LoginRetrofitActivity,
                            "Login Success",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Log.d("response.isSuccessful >>>>", response.isSuccessful.toString() + " I'm working in thread " + Thread.currentThread().name)
                    Log.d("response code >>>", response.code().toString())
                    val userData = response.body()

                    userData?.let {
                        Log.d("it.resultObject >>>", it.resultObject.toString())
                        val data = Gson().fromJson(it.resultObject, UserData::class.java)
                        // resultObject 값이 JsonObject 형태를 가지는데 Gson은 key/value 자동매핑 지원한다
                        Log.d("data >> ", data.toString())

                        Log.d("data.OpNo >> ", data.OpNo)
                        Log.d("data.OpId >> ", data.OpId)
                        Log.d("data.OpNm >> ", data.OpNm)
                        Log.d("data.OfficeCode >> ", data.OfficeCode)
                        Log.d("data.OfficeName >> ", data.OfficeName)
                    }

                } else {
                    withContext(Dispatchers.Main) {

                        Toast.makeText(
                            this@LoginRetrofitActivity,
                            response.code(),
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.d("response.code() >>>>>", response.code().toString() + " I'm working in thread " + Thread.currentThread().name)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LoginRetrofitActivity, e.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("e.toString() >>>>>>>>", e.toString() + "I'm working in thread " + Thread.currentThread().name)
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
    private fun checkLoginAsynchronous(id: String, pw: String) {
        var req = User(
            id, pw, "N", "e505a053e5d7e99", "",
            "37.499756", "127.032454"
        )
        IApi.login(req).enqueue(object : Callback<ApiModel> {
            override fun onResponse(call: Call<ApiModel>, response: Response<ApiModel>) {
                Log.d("onResponse >>> ", response.body().toString() + " I'm working in thread " + Thread.currentThread().name)
                Toast.makeText(this@LoginRetrofitActivity, "success", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<ApiModel>, t: Throwable) {
                Log.d("onFailure msg >>>", t.message.toString())
            }

        })
    }

    override fun onDestroy() {
        coroutineScopeList.forEach {
            if (it.isActive) {
                println("Before >>>> " + it.isActive)
                it.cancel()
                println("after >>>>" + it.isActive)
            }
        }
        super.onDestroy()
    }

    override fun onClick(v: View?) {
        jsonArrayCheck()
    }

    private fun jsonArrayCheck() {

        val checkJsonArrayCoroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScopeList.add(checkJsonArrayCoroutineScope)

        checkJsonArrayCoroutineScope.launch {
            try {
                val req = WorkSchedule(
                    "2021-08-02", "2021-08-03"
                )
                val response = IApi.jsonArrayCheck(req).execute()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginRetrofitActivity,
                            "JsonArray Success",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    val jsonArrayData = response.body()
                    jsonArrayData?.let {
                        Log.d("it.resultObject >>",it.resultObject.toString())
                        val data : ArrayList<JsonArrayData> = Gson().fromJson(it.resultObject,object : TypeToken<ArrayList<JsonArrayData>>() {}.type)

                        val simpleData = Gson().fromJson(it.resultObject,Array<JsonArrayData>::class.java).toList()

                        Log.d("simpleData >>",simpleData[0].onoff)
                        Log.d("simpleData >>",simpleData[0].date)
                        Log.d("simpleData >>",simpleData[0].driver_id)

                        Log.d("data >> ", data.get(0).onoff)
                        Log.d("data >> ", data.get(0).date)
                        Log.d("data >> ", data.get(0).driver_id)
                    }

                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginRetrofitActivity,
                            response.code(),
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.d("response.code() >>>>>", response.code().toString() + " I'm working in thread " + Thread.currentThread().name)
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LoginRetrofitActivity, e.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("e.toString() >>>>>>>>", e.toString() + " I'm working in thread " + Thread.currentThread().name)
                }
            }
        }

    }


    @SuppressLint("LongLogTag")
    private fun checkSuspendLogin(id: String, pw: String) {

        val checkLoginCoroutineScope = CoroutineScope(Dispatchers.IO)
        // Dispatchers.IO 는 네트워크 혹은 내부 DB 접근 등 백그라운드에서 필요한 작업을 수행 할때 사용
        coroutineScopeList.add(checkLoginCoroutineScope)

        checkLoginCoroutineScope.launch {
            try {
                var req = User(
                    id, pw, "N", "e505a053e5d7e99", "",
                    "37.499756", "127.032454"
                )

                val response = IApi.suspendLogin(req).execute()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        // Dispatchers.Main 은 말그대로 메인쓰레드에 대한 Context 이며 UI 갱신이나 Toast 등의 View 작업에 사용


                        Toast.makeText(
                            this@LoginRetrofitActivity,
                            "Login Success",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Log.d("response.isSuccessful >>>>", response.isSuccessful.toString())
                    Log.d("response code >>>", response.code().toString())
                    val userData = response.body()

                    userData?.let {
                        Log.d("it.resultObject >>>", it.resultObject.toString())
                        val data = Gson().fromJson(it.resultObject, UserData::class.java)
                        // resultObject 값이 JsonObject 형태를 가지는데 Gson은 key/value 자동매핑 지원한다
                        Log.d("data >> ", data.toString())

                        Log.d("data.OpNo >> ", data.OpNo)
                        Log.d("data.OpId >> ", data.OpId)
                        Log.d("data.OpNm >> ", data.OpNm)
                        Log.d("data.OfficeCode >> ", data.OfficeCode)
                        Log.d("data.OfficeName >> ", data.OfficeName)
                    }

                } else {
                    withContext(Dispatchers.Main) {

                        Toast.makeText(
                            this@LoginRetrofitActivity,
                            response.code(),
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.d("response.code() >>>>>", response.code().toString())
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LoginRetrofitActivity, e.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("e.toString() >>>>>>>>", e.toString())
                }
            }
        }
    }

}