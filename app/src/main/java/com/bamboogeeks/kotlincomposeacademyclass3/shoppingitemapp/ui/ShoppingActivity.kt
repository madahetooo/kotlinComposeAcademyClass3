package com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.ui

import ShoppingDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboogeeks.kotlincomposeacademyclass3.R
import com.bamboogeeks.kotlincomposeacademyclass3.databinding.ActivityShoppingBinding
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.model.ShoppingItem
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.repository.ShoppingRepository
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.ui.utils.ShoppingItemAdapter

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)
        val shoppingItemAdapter = ShoppingItemAdapter(listOf(),viewModel)
        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = shoppingItemAdapter

        viewModel.readItems().observe(this, Observer { listOfShoppingItem ->
            shoppingItemAdapter.items = listOfShoppingItem
            shoppingItemAdapter.notifyDataSetChanged()

        })

        binding.fabAddShoppingItem.setOnClickListener {
        AddShoppingItemDialog(this, object :AddDialogListener{
            override fun onAddButtonClicked(item: ShoppingItem) {
                viewModel.upsertItem(item)
            }
        }).show()
        }
    }
}