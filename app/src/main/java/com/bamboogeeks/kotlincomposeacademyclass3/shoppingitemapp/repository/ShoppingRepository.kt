package com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.repository

import ShoppingDatabase
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.model.ShoppingItem

class ShoppingRepository(private val db:ShoppingDatabase) {

    fun upsertItem(item: ShoppingItem) = db.getShoppingDao().upsertItem(item)

    fun deleteItem(item: ShoppingItem) = db.getShoppingDao().deleteItem(item)

    fun readItems() = db.getShoppingDao().readItems()
}