package com.example.myapplication

import kotlinx.coroutines.delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemRepository {
    suspend fun getItems(): List<Item> = withContext(Dispatchers.IO) {
        delay(1000) // Simulate network delay
        List(20) { index ->
            Item(
                id = index.toString(),
                title = "Item $index",
                description = "Description for item $index"
            )
        }
    }
}
