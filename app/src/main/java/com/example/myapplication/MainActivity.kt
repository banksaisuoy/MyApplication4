package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val itemAdapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = itemAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.items.observe(this) { items ->
            itemAdapter.submitList(items)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.recyclerView.visibility = if (isLoading) View.GONE else View.VISIBLE
        }

        viewModel.error.observe(this) { errorMessage ->
            if (errorMessage != null) {
                // In a real app we might show a Snackbar or Toast.
                // For this example, just to prove we are handling it:
                android.widget.Toast.makeText(this, errorMessage, android.widget.Toast.LENGTH_LONG).show()
            }
        }
    }
}
