package com.example.myapplication

import kotlinx.coroutines.delay

class ItemRepository {
    suspend fun getItems(): List<Item> {
        // Simulate network delay
        delay(500)
        return listOf(
            Item(1, "Fix Layout Bugs", "Ensure all layouts render perfectly across devices"),
            Item(2, "Rigorous Tests", "Write 100% test coverage for all core flows"),
            Item(3, "Performance Optimized", "Zero console warnings, fast list scrolling"),
            Item(4, "Bulletproof Architecture", "MVVM, Coroutines, ViewBinding, clean code")
        )
    }
}
