package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val tasks: List<Task>,
    private val onTaskClick: (Task, Int) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTaskTitle: TextView = view.findViewById(R.id.tvTaskTitle)
        val tvTaskDescription: TextView = view.findViewById(R.id.tvTaskDescription)
        val tvStatus: TextView = view.findViewById(R.id.tvStatus)
        val ivStatus: ImageView = view.findViewById(R.id.ivStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.tvTaskTitle.text = task.title
        holder.tvTaskDescription.text = task.description

        if (task.isCompleted) {
            holder.tvStatus.text = "Completed"
            holder.ivStatus.setImageResource(android.R.drawable.checkbox_on_background)
        } else {
            holder.tvStatus.text = "Pending"
            holder.ivStatus.setImageResource(android.R.drawable.checkbox_off_background)
        }

        holder.itemView.setOnClickListener {
            onTaskClick(task, position)
        }
    }

    override fun getItemCount() = tasks.size
}