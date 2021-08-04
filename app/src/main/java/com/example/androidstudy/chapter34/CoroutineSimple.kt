package com.example.androidstudy.chapter34

import android.app.Activity
import android.os.Bundle
import kotlinx.coroutines.*

class CoroutineSimple : Activity() {

    private val coroutineScopeList = ArrayList<CoroutineScope>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
    }
//    fun main() {
//        val coroutineScope = CoroutineScope(Dispatchers.Main)
//        val job : Job = coroutineScope.launch {
//            delay(1000L)
//            println("coroutine launch")
//        }
//        println("call in main")
//        println("job.isActive >> " + job.isActive)
//        Thread.sleep(5000L)
//        println("job.isActive >>> " + job.isActive)
//    }

//    fun main() {
//        GlobalScope.launch { // 백그라운드에서 작업하는 새로운 코루틴
//            delay(1000L) // non-blocking한 1초 딜레이
//            println("World!") // 딜레이 후 프린트
//        }
//        println("Hello,") // 코루틴이 딜레이를 주는 동안 메인 스레드는 계속 실행 중
//        Thread.sleep(2000L) // JVM의 작업을 유지하기 위해 메인 스레드를 2초간 블록
//    }

    /*    fun main() {
            GlobalScope.launch {
                delay(1000L)
                println("world!")
            }
            println("Hello")
            runBlocking {
                delay(2000L)
            }
        }*/
/*    fun main() = runBlocking<Unit> {
        GlobalScope.launch {
            delay(1000L)
            println("World")
        }
        println("Hello,")
        delay(2000L)
    }*/
/*    fun main() = runBlocking {

        val job = GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join()  //하위 코루틴이 완료될때까지 기다림
    }*/

    /*fun main() = runBlocking {
        launch {
            delay(200L)
            println("Task from runBlocking")    ///22
        }

        coroutineScope { // 코루틴 스코프 생성
            launch {
                delay(500L)
                println("Task from nested launch")  //3
            }

            delay(100L)
            println("Task from coroutine scope") // 이 라인은 nested launch가 출력되기 전에 실행됩니다.1111
        }

        println("Coroutine scope is over") // 이 라인은 하위 launch가 완료되기 전까지 실행되지 않습니다.  444
    }*/
    fun main() {
//        val coroutineScope = CoroutineScope(Dispatchers.Main)
//        coroutineScope.launch {
//            println("start")
//            println("1111111 " + isActive)
//            withContext(Dispatchers.Main) {
//                println("22222222 " + isActive)
//            }
//            println("3333333 " + isActive)
//        }
    }
}