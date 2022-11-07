package com.bamboogeeks.kotlincomposeacademyclass3.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bamboogeeks.kotlincomposeacademyclass3.MainActivity
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val goToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(goToMainActivity)
        }

        binding.tvSignUp.setOnClickListener {
            val goToSignUpActivity = Intent(this, RegistrationActivity::class.java)
            startActivity(goToSignUpActivity)
        }

    }
}