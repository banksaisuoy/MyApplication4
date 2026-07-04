package com.example.myapplication

data class Task(
    val id: Int,
    val title: String,
    val description: String
) {
    companion object {
        fun generateMockData(): List<Task> {
            val mockData = mutableListOf<Task>()
            for (i in 1..20) {
                mockData.add(
                    Task(
                        id = i,
                        title = "Task $i",
                        description = "Description for task $i"
                    )
                )
            }
            return mockData
        }
    }
}
