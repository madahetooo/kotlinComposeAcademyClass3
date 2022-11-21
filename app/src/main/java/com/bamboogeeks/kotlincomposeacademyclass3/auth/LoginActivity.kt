package com.bamboogeeks.kotlincomposeacademyclass3.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.kotlincomposeacademyclass3.MainActivity
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener {
            val emailAddress = binding.etEmailAddress.text.toString() // GET EMAIL ADDRESS
            val password = binding.etPassword.text.toString() // GET EMAIL ADDRESS

            if (emailAddress.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(emailAddress,password)
                    .addOnCompleteListener (this){ task ->
                        if (task.isSuccessful){
                            val user = auth.currentUser
                            val goToMainActivity = Intent(this, MainActivity::class.java)
                            startActivity(goToMainActivity)
                            finish()
                        }else
                        {
                            Toast.makeText(baseContext,"Authentication Failed",Toast.LENGTH_LONG).show()
                        }
                    }
            }

            val goToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(goToMainActivity)
        }

        binding.tvSignUp.setOnClickListener {
            val goToSignUpActivity = Intent(this, RegistrationActivity::class.java)
            startActivity(goToSignUpActivity)
        }

    }
}