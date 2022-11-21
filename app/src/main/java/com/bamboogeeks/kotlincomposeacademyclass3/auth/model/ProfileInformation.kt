package com.bamboogeeks.kotlincomposeacademyclass3.auth.model

data class ProfileInformation(
    val fullName:String="",
    val emailAddress:String="",
    val phoneNumber:String="",
    val password:String="",
) {
}