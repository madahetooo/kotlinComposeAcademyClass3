package com.bamboogeeks.kotlincomposeacademyclass3.coroutineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import com.bamboogeeks.kotlincomposeacademyclass3.R
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityCoroutineAppBinding
import kotlinx.coroutines.*

class CoroutineApp : AppCompatActivity() {

    val TAG = "CoroutineApp"
    private lateinit var binding: ActivityCoroutineAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.IO) {

            var answer1 = async { doNetworkCall1() }
            var answer2 = async { doNetworkCall2() }
            Log.d(TAG,"Answer 1 is : ${answer1.await()}")
            Log.d(TAG,"Answer 2 is : ${answer2.await()}")

//            var answer1:String? =null
//            var answer2:String? =null
//
//            val job1 = launch(Dispatchers.IO) {
//               answer1 = doNetworkCall1()
//            }
//            val job2 = launch(Dispatchers.IO) {
//                answer2 = doNetworkCall2()
//            }
//            job1.join()
//            job2.join()
//            Log.d(TAG,"Answer 1 is : $answer1")
//            Log.d(TAG,"Answer 2 is : $answer2")
        }

    }

    suspend fun doNetworkCall1():String{
        delay(4000L)
        return "Answer 1"
    }
    suspend fun doNetworkCall2():String{
        delay(4000L)
        return "Answer 2"
    }
}