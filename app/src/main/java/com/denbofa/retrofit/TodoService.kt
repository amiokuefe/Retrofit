package com.denbofa.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface TodoService {
    @GET("todos")
    fun getAllTodos(): Call<List<Todo>>
}