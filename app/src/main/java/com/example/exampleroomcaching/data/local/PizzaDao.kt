package com.example.exampleroomcaching.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exampleroomcaching.data.entity.Pizza
import kotlinx.coroutines.flow.Flow


@Dao
interface PizzaDao {
    @Query("SELECT * FROM pizza_table")
    fun getAllPizza(): Flow<List<Pizza>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizzas(pizza: List<Pizza>)

    @Query("DELETE FROM pizza_table")
    suspend fun deleteAllPizzas()



}