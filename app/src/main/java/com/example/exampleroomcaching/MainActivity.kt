package com.example.exampleroomcaching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampleroomcaching.databinding.ActivityMainBinding
import com.example.exampleroomcaching.ui.MainAdapter
import com.example.exampleroomcaching.ui.MainViewModel
import com.example.exampleroomcaching.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding: ActivityMainBinding get() = _binding
    private val viewModel by viewModels<MainViewModel>()
    lateinit var pizzaAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initViewModel()
    }

    private fun initAdapter(){
        pizzaAdapter = MainAdapter()
        recyclerView.apply {
            adapter = pizzaAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun initViewModel(){
        viewModel.pizzas.observe(this@MainActivity){
            pizzaAdapter.submitList(it.data)
            progressBar.isVisible = it is Resource.Loading<*> && it.data.isNullOrEmpty()
            tv_error.isVisible = it is Resource.Error<*> && it.data.isNullOrEmpty()
            tv_error.text = it.error?.localizedMessage
        }
    }
}