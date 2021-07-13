package com.denbofa.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denbofa.retrofit.databinding.TodoItemBinding

class TodoAdapter(var lists: List<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(list: Todo){
            binding.textView.text = list.title

            if (list.completed){
                binding.image.visibility = View.VISIBLE
            }else {
                binding.image.visibility = View.INVISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding: TodoItemBinding = TodoItemBinding.inflate(LayoutInflater.from(parent.context))
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val singleTodo = lists.get(position)
        holder.bind(singleTodo)
    }

    override fun getItemCount(): Int {
        return lists.size
    }
}