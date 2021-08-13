package com.example.androidstudy.chapter38

import com.example.androidstudy.chapter34.restful.RetrofitService
import org.koin.dsl.module

interface Repository

class MyRepository() : Repository


// 현재 module 안에 single로 MyRepository()를 넣어주었는데 이것은 Repository를 singleton으로 주입하되 그것의 구현체로 MyRepository()를 주입해주는 것을 의미
val MyModule = module {

    single<Repository> { MyRepository() }

    //factory로 정의하여 항상 새로운 인스턴스를 RetrofitService 타입으로 생성함
    factory<RetrofitService> { MyRetrofitService(get()) }


}