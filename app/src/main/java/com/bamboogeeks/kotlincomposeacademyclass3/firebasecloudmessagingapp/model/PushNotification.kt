package com.bamboogeeks.kotlincomposeacademyclass3.firebasecloudmessagingapp.model

data class PushNotification(
    val notificationData: NotificationData,
    val to:String
) {
}