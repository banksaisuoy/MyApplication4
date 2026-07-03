package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val destinations = listOf(
            Destination("1", "Paris, France", "The city of love and lights. Experience the Eiffel Tower, the Louvre, and fine dining."),
            Destination("2", "Kyoto, Japan", "Discover ancient temples, traditional tea houses, and beautiful cherry blossoms."),
            Destination("3", "New York City, USA", "The city that never sleeps. Explore Times Square, Central Park, and Broadway."),
            Destination("4", "Rome, Italy", "Step back in time with the Colosseum, the Pantheon, and authentic Italian cuisine."),
            Destination("5", "Sydney, Australia", "Enjoy the iconic Opera House, Bondi Beach, and vibrant harbor life.")
        )

        val adapter = DestinationAdapter(destinations)
        recyclerView.adapter = adapter
    }
}