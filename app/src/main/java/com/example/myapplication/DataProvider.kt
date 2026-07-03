package com.example.myapplication

object DataProvider {
    fun getItems(): List<Item> {
        return listOf(
            Item(1, "Item 1", "Description for Item 1"),
            Item(2, "Item 2", "Description for Item 2"),
            Item(3, "Item 3", "Description for Item 3"),
            Item(4, "Item 4", "Description for Item 4"),
            Item(5, "Item 5", "Description for Item 5")
        )
    }
}
