package com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityAddShoppingItemDialogBinding
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.model.ShoppingItem

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {
    private lateinit var binding: ActivityAddShoppingItemDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddShoppingItemDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShoppingDialogAdd.setOnClickListener {
            val shoppingItemName = binding.etShoppingItemDialogName.text.toString()
            val shoppingItemAmount = binding.etShoppingItemDialogAmount.text.toString()

            if (shoppingItemName.isEmpty() || shoppingItemAmount.isEmpty()) {
                Toast.makeText(context, "Please enter item name or amount", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            val item = ShoppingItem(shoppingItemName, shoppingItemAmount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        binding.btnShoppingDialogCancel.setOnClickListener {
            cancel()
        }
    }
}