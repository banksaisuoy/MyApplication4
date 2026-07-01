package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public static List<Task> getMockTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Complete project analysis", "Review the requirements and prepare the architecture document.", true));
        tasks.add(new Task(2, "Design UI mockups", "Create modern and breathtaking wireframes for the main screens.", false));
        tasks.add(new Task(3, "Implement RecyclerView", "Build the adapter and layout for the task list.", false));
        tasks.add(new Task(4, "Setup CI/CD pipeline", "Configure GitHub actions to run tests and linters automatically.", false));
        tasks.add(new Task(5, "Write unit tests", "Ensure 100% test coverage for the repository and utility classes.", false));
        return tasks;
    }
}
