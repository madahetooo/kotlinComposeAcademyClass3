package com.bamboogeeks.kotlincomposeacademyclass3.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bamboogeeks.kotlincomposeacademyclass3.R
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            //Check if the input is EMPTY
            if (binding.et1stNumber.text.isNotEmpty() && binding.et2ndNumber.text.isNotEmpty()){

             val firstNumber =    binding.et1stNumber.text.toString().toInt() // GET FIRST NUMBER
             val secondNumber =    binding.et2ndNumber.text.toString().toInt() // GET SECOND NUMBER

             val result =   firstNumber + secondNumber // ADDITION OPERATION AND SAVE IT IN RESULT VARIABLE
                binding.tvResult.text = result.toString() // SET RESULT TO THE TEXTVIEW
            }
            else{
                Toast.makeText(this,"Please fill the required data",Toast.LENGTH_LONG).show()
            }
        }
        binding.btnMinus.setOnClickListener {
            //Check if the input is EMPTY
            if (binding.et1stNumber.text.isNotEmpty() && binding.et2ndNumber.text.isNotEmpty()){

                val firstNumber =    binding.et1stNumber.text.toString().toInt() // GET FIRST NUMBER
                val secondNumber =    binding.et2ndNumber.text.toString().toInt() // GET SECOND NUMBER

                val result =   firstNumber - secondNumber // ADDITION OPERATION AND SAVE IT IN RESULT VARIABLE
                binding.tvResult.text = result.toString() // SET RESULT TO THE TEXTVIEW
            }
            else{
                Toast.makeText(this,"Please fill the required data",Toast.LENGTH_LONG).show()
            }
        }
        binding.btnDivision.setOnClickListener {
            //Check if the input is EMPTY
            if (binding.et1stNumber.text.isNotEmpty() && binding.et2ndNumber.text.isNotEmpty()){

                val firstNumber =    binding.et1stNumber.text.toString().toInt() // GET FIRST NUMBER
                val secondNumber =    binding.et2ndNumber.text.toString().toInt() // GET SECOND NUMBER

                val result =   firstNumber / secondNumber // ADDITION OPERATION AND SAVE IT IN RESULT VARIABLE
                binding.tvResult.text = result.toString() // SET RESULT TO THE TEXTVIEW
            }
            else{
                Toast.makeText(this,"Please fill the required data",Toast.LENGTH_LONG).show()
            }
        }
        binding.btnMultiplication.setOnClickListener {
            //Check if the input is EMPTY
            if (binding.et1stNumber.text.isNotEmpty() && binding.et2ndNumber.text.isNotEmpty()){

                val firstNumber =    binding.et1stNumber.text.toString().toInt() // GET FIRST NUMBER
                val secondNumber =    binding.et2ndNumber.text.toString().toInt() // GET SECOND NUMBER

                val result =   firstNumber * secondNumber // ADDITION OPERATION AND SAVE IT IN RESULT VARIABLE
                binding.tvResult.text = result.toString() // SET RESULT TO THE TEXTVIEW
            }
            else{
                Toast.makeText(this,"Please fill the required data",Toast.LENGTH_LONG).show()
            }
        }

        binding.btnResetValues.setOnClickListener {
            binding.et1stNumber.text.clear()
            binding.et2ndNumber.text.clear()
            binding.tvResult.setText("Result Here:")
            Toast.makeText(this,"Values Resetted",Toast.LENGTH_LONG).show()
        }
    }
}