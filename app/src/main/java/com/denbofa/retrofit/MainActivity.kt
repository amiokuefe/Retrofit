package com.denbofa.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.denbofa.retrofit.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mytodoAdapter: TodoAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mytodoAdapter = TodoAdapter(listOf())
        binding.recycler.adapter = mytodoAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllTodos()
            items.observe(this@MainActivity, {todo ->
                mytodoAdapter.lists = todo
                mytodoAdapter.notifyDataSetChanged()
            })
        }
    }
}