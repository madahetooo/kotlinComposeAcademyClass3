package com.bamboogeeks.kotlincomposeacademyclass3.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bamboogeeks.kotlincomposeacademyclass3.MainActivity
import com.bamboogeeks.kotlincomposeacademyclass3.auth.model.ProfileInformation
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var auth:FirebaseAuth
    private val profileInformationCollectionRef = Firebase.firestore.collection("ProfileInformation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.btnSignUp.setOnClickListener {
          val emailAddress =  binding.etEmailAddressRegistration.text.toString()
          val password =  binding.etPasswordRegistration.text.toString()
            val profileInformation = getProfileInformation()
            if (profileInformation !=null){
                saveProfileInformation(profileInformation)
            }else{
                Toast.makeText(baseContext,"Please fill the required Data",Toast.LENGTH_LONG).show()
            }
            if (emailAddress.isNotEmpty() && password.isNotEmpty()){
                auth.createUserWithEmailAndPassword(emailAddress,password).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val user = auth.currentUser
                        val goToMainActivity = Intent(this, MainActivity::class.java)
                        startActivity(goToMainActivity)
                        finish()
                    }
                }
            }

        }
        binding.tvLogin.setOnClickListener {
            val goToMainActivity = Intent(this, LoginActivity::class.java)
            startActivity(goToMainActivity)
        }

    }

    private fun getProfileInformation() : ProfileInformation{
      val fullName =  binding.etFullName.text.toString()
      val emailAddress =  binding.etEmailAddressRegistration.text.toString()
      val phoneNumber =  binding.etPhoneNumber.text.toString()
      val password =  binding.etPasswordRegistration.text.toString()

        return ProfileInformation(fullName,emailAddress,phoneNumber,password)
    }

    private fun saveProfileInformation(profileInformation: ProfileInformation){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                profileInformationCollectionRef.add(profileInformation) // SAVE DATA TO FIREBASE STORAGE
                withContext(Dispatchers.Main){
                    Toast.makeText(this@RegistrationActivity,"Data Saved Successfully",Toast.LENGTH_LONG).show()
                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@RegistrationActivity,e.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}