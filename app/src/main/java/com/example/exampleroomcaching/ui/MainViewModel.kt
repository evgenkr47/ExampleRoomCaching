package com.example.exampleroomcaching.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.exampleroomcaching.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: Repository): ViewModel() {
    val pizzas = repository.getPizzas().asLiveData()
}