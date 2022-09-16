package com.example.exam8.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam8.common.resource.Resource
import com.example.exam8.databinding.ActivityMainBinding
import com.example.exam8.domain.model.Items
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val itemAdapter = MainAdapter()

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observers()
        itemAdd()


    }

    private fun init() {
        binding.recycleView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.items().collect {
                when (it) {
                    is Resource.Success -> {
                        itemAdapter.submitList(it.list as MutableList<Items>)
                    }

                    is Resource.Error -> {
                        Toast.makeText(this@MainActivity, it.errorMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun itemAdd() {
        itemAdapter.itemClick = {
            count++
        }

        binding.tvCount.text = count.toString()
    }
}