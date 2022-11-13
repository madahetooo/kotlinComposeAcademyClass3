package com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.bamboogeeks.kotlincomposeacademyclass3.shoppingitemapp.model.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertItem(item:ShoppingItem)

    @Delete
    fun deleteItem(item:ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun readItems() : LiveData<List<ShoppingItem>>

}