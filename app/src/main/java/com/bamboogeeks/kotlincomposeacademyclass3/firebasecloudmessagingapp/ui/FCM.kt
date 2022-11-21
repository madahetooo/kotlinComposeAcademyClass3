package com.bamboogeeks.kotlincomposeacademyclass3.firebasecloudmessagingapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityFcmBinding
import com.bamboogeeks.kotlincomposeacademyclass3.firebasecloudmessagingapp.model.NotificationData
import com.bamboogeeks.kotlincomposeacademyclass3.firebasecloudmessagingapp.model.PushNotification
import com.bamboogeeks.kotlincomposeacademyclass3.firebasecloudmessagingapp.service.FirebaseService
import com.bamboogeeks.kotlincomposeacademyclass3.firebasecloudmessagingapp.service.RetrofitInstance
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val TOPIC ="/topics/myTopic"
class FCM : AppCompatActivity() {
    val TAG = "FCM"
    private lateinit var binding: ActivityFcmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFcmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseService.sharedPref = getSharedPreferences("sharedPrefFile", Context.MODE_PRIVATE)
        FirebaseMessaging.getInstance().token.addOnSuccessListener {
            FirebaseService.token=it
            binding.etNotificationToken.setText(it)
        }

        binding.btnSendNotification.setOnClickListener {
            val notificationTitle = binding.etNotificationTitle.text.toString()
            val notificationMessage = binding.etNotificationMessage.text.toString()
            val recipientToken = binding.etNotificationToken.text.toString()
            if (notificationTitle.isNotEmpty() && notificationMessage.isNotEmpty() && recipientToken.isNotEmpty()){
                PushNotification(NotificationData(notificationTitle,notificationMessage),recipientToken).also {
                    sendNotification(it)
                }
            }
        }

    }

    private fun sendNotification(notification: PushNotification) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.api.postNotification(notification)
                if (response.isSuccessful) {
//                    Log.d(TAG, "${Gson().toJson(response)}")
                } else {
//                    Log.d(TAG, response.errorBody().toString())

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@FCM, e.message, Toast.LENGTH_LONG).show()
                }
            }
        }
}