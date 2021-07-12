package com.denbofa.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denbofa.retrofit.databinding.ActivityMainBinding
import retrofit2.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val service: TodoService = retrofit.create(TodoService::class.java)
        val todos: Call<List<Todo>> = service.getAllTodos()
        todos.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}