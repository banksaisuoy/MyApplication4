package com.example.myapplication

import java.util.UUID

class MockDataRepository {

    fun getTasks(): List<Task> {
        return listOf(
            Task(
                id = UUID.randomUUID().toString(),
                title = "Design new UI mockups",
                description = "Create high fidelity mockups for the new feature dashboard using Material Design 3 guidelines."
            ),
            Task(
                id = UUID.randomUUID().toString(),
                title = "Update build configuration",
                description = "Upgrade compileSdk and targetSdk to version 34 to resolve modern AndroidX dependencies build issues."
            ),
            Task(
                id = UUID.randomUUID().toString(),
                title = "Implement Task RecyclerView",
                description = "Develop the main activity layout with a RecyclerView and custom item layout for displaying tasks."
            ),
            Task(
                id = UUID.randomUUID().toString(),
                title = "Write Unit Tests",
                description = "Ensure 100% test coverage for the MockDataRepository and task logic using JUnit."
            ),
            Task(
                id = UUID.randomUUID().toString(),
                title = "Create Instrumented UI Tests",
                description = "Write Espresso tests to verify that the MainActivity correctly renders the list and interactions."
            )
        )
    }
}