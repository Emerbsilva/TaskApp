package com.ebsindustrial.taskapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebsindustrial.taskapp.data.model.Task
import com.ebsindustrial.taskapp.databinding.ItemTaskBinding

class TaskAdapter (
    private val taskList: List<Task>
        ) : RecyclerView.Adapter<TaskAdapter.MyViewHolder> () {

    // Cria a visualização para cada linha
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder (ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    // Exibe cada informação dinamicamente
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]

        holder.binding.textDesscricao.text = task.descriptor
    }

    // faz a listagem dos itens da nossa lista
    //override fun getItemCount(): = taskList.size
    override fun getItemCount(): Int = taskList.size

    // inner class significa que é uma classe usada internamente
    // atribui as referencias dos nossos itens
    inner class MyViewHolder (val binding: ItemTaskBinding)
        : RecyclerView.ViewHolder(binding.root)
}