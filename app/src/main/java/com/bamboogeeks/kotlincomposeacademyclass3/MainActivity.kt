package com.bamboogeeks.kotlincomposeacademyclass3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlincomposeacademyclass3.R
import com.bamboogeeks.kotlincomposeacademyclass3.broadcastreceiverapp.BroadcastReceiverExample
import com.bamboogeeks.kotlincomposeacademyclass3.calculatorapp.CalculatorActivity
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityMainBinding
import com.bamboogeeks.kotlincomposeacademyclass3.firebasecloudmessagingapp.ui.FCM
import com.bamboogeeks.kotlincomposeacademyclass3.notificationapp.NotificationExample
import com.bamboogeeks.kotlincomposeacademyclass3.restuarntapp.RestaurantActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculatorapp.setOnClickListener {
            val intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
        binding.btnRestaurantapp.setOnClickListener {
            val intent = Intent(this,RestaurantActivity::class.java)
            startActivity(intent)
        }
        binding.btnNotificationapp.setOnClickListener {
            val intent = Intent(this,NotificationExample::class.java)
            startActivity(intent)
        }
        binding.btnBroadcastReceiver.setOnClickListener {
            val intent = Intent(this,BroadcastReceiverExample::class.java)
            startActivity(intent)
        }
        binding.btnFCM.setOnClickListener {
            val intent = Intent(this,FCM::class.java)
            startActivity(intent)
        }
    }
}