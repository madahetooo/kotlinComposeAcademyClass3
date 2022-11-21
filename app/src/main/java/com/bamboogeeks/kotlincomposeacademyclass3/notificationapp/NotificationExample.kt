package com.bamboogeeks.kotlincomposeacademyclass3.notificationapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bamboogeeks.kotlincomposeacademyclass3.R
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityNotificationExampleBinding

class NotificationExample : AppCompatActivity() {
    val CHANNEL_ID ="channelID"
    val CHANNEL_NAME="channelName"
    val NOTIFICATION_ID=0
    private lateinit var binding: ActivityNotificationExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNotificationExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createNotificationChannel()
        val intent = Intent(this,NotificationExample::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_IMMUTABLE)
        }
        val customNotification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Custom Notification Title")
            .setContentText("This is a custom notification you can build")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManger = NotificationManagerCompat.from(this)
        binding.btnShowNotification.setOnClickListener {
            notificationManger.notify(NOTIFICATION_ID,customNotification)
        }

    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor= Color.RED
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}