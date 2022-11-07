package com.bamboogeeks.kotlincomposeacademyclass3.restuarntapp

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityRestaurantBinding

class RestaurantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOrder.setOnClickListener {
            val checkedRadioButtonId = binding.rgMeals.checkedRadioButtonId
            val burger = findViewById<RadioButton>(checkedRadioButtonId)
            val cheese = binding.chkCheese.isChecked
            val salad = binding.chkSalad.isChecked
            val onionRing = binding.chkOnionRing.isChecked
            val totalOrder = "You ordered burger with \n " + "${burger.text}" +
                    (if (cheese) "\n Cheese " else "") +
                    (if (salad) "\n Salad " else "") +
                    (if (onionRing) "\n Onion Ring " else "")
            binding.tvTotalOrder.text = totalOrder
        }

    }
}