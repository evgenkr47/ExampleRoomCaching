package com.example.exampleroomcaching.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exampleroomcaching.data.entity.Pizza

@Database(entities = [Pizza::class], version = 1, exportSchema = true)
abstract class PizzaDataBase: RoomDatabase() {
    abstract fun getPizzaDao(): PizzaDao
}