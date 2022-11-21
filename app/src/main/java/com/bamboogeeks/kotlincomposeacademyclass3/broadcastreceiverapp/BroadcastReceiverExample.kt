package com.bamboogeeks.kotlincomposeacademyclass3.broadcastreceiverapp

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlincomposeacademyclass3.R
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityBroadcastReceiverExampleBinding

class BroadcastReceiverExample : AppCompatActivity() {
    private lateinit var binding: ActivityBroadcastReceiverExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBroadcastReceiverExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(AirPlaneModeChangedReceiver(),it)
        }
    }
}