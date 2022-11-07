package com.bamboogeeks.kotlincomposeacademyclass3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bamboogeeks.kotlincomposeacademyclass3.auth.LoginActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        Handler().postDelayed({
            // MOVE FROM SPLASH SCREEN TO LOGIN SCREEN
            val goToLoginActivity = Intent(this, LoginActivity::class.java)
            startActivity(goToLoginActivity)

            //KILLING THE SPLASH SCREEN
            finish()

        },6000)
    }
}