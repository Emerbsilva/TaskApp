package com.ebsindustrial.taskapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ebsindustrial.taskapp.R
import com.ebsindustrial.taskapp.data.model.Status
import com.ebsindustrial.taskapp.data.model.Task
import com.ebsindustrial.taskapp.databinding.ItemTaskBinding

class TaskAdapter(
    private val context: Context,
    private val taskList: List<Task>
) : RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    // Cria a visualização para cada linha
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Exibe cada informação dinamicamente
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]

        holder.binding.textDesscricao.text = task.descriptor

        setIndicators(task, holder)
    }

    private fun setIndicators(task: Task, holder: MyViewHolder) {
        when (task.status) {
            Status.TODO -> {
                holder.binding.btBack.isVisible = false
            }

            Status.DOING -> {
                holder.binding.btBack.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_status_todo
                    )
                )

                holder.binding.btNext.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_status_done
                    )
                )
            }

            Status.DONE -> {
                holder.binding.btNext.isVisible = false
            }
        }
    }

    // faz a listagem dos itens da nossa lista
    //override fun getItemCount(): = taskList.size
    override fun getItemCount(): Int = taskList.size

    // inner class significa que é uma classe usada internamente
    // atribui as referencias dos nossos itens
    inner class MyViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)
}