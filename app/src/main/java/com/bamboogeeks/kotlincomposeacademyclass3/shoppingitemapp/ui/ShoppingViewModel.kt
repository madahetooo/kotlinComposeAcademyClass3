package com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.ui

import androidx.lifecycle.ViewModel
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.model.ShoppingItem
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel(){

    fun upsertItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.upsertItem(item)
    }

    fun deleteItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.deleteItem(item)
    }

    fun readItems() = repository.readItems()
}