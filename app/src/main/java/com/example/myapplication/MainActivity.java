package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private TaskAdapter taskAdapter;
    private List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tasks = TaskRepository.getMockTasks();
        taskAdapter = new TaskAdapter(tasks);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(taskAdapter);

        binding.fab.setOnClickListener(v -> {
            int newId = tasks.size() + 1;
            tasks.add(new Task(newId, "New Dynamic Task", "Description for the newly added task " + newId, false));
            taskAdapter.notifyItemInserted(tasks.size() - 1);
            binding.recyclerView.scrollToPosition(tasks.size() - 1);
        });
    }
}
