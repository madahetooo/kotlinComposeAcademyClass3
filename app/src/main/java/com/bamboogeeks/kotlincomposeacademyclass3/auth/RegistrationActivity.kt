package com.bamboogeeks.kotlincomposeacademyclass3.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlincomposeacademyclass3.MainActivity
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val goToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(goToMainActivity)
        }
        binding.tvLogin.setOnClickListener {
            val goToMainActivity = Intent(this, LoginActivity::class.java)
            startActivity(goToMainActivity)
        }

    }

}