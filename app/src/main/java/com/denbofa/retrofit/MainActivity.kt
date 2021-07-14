package com.denbofa.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denbofa.retrofit.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mytodoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mytodoAdapter = TodoAdapter(listOf())
        binding.recycler.adapter = mytodoAdapter

        val todos: Call<List<Todo>> = RetrofitProvider.service.getAllTodos()

        todos.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        mytodoAdapter.lists = it
                        mytodoAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
            }

        })

    }
}