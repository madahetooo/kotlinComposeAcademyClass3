package com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.repository.ShoppingRepository

class ShoppingViewModelFactory(private val repository: ShoppingRepository)
    : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}