package com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.ui

import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.model.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}