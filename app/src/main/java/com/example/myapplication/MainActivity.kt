package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val mockedTasks = listOf(
            Task(1, "Buy Groceries", "Milk, Eggs, Bread, and Coffee", false),
            Task(2, "Finish Report", "Complete the quarterly financial report", true),
            Task(3, "Call Mom", "Wish her a happy birthday", false),
            Task(4, "Schedule Dentist Appointment", "Call Dr. Smith's office", false),
            Task(5, "Pay Bills", "Electricity, Water, and Internet", true)
        )

        val adapter = TaskAdapter(mockedTasks)
        recyclerView.adapter = adapter
    }
}