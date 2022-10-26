package com.example.exampleroomcaching.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza_table")
data class Pizza (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val description: String,
    val image: String,
    val price: String,
    val title: String
    )