package com.example.myapplication

class ItemRepository {
    fun getItems(): List<Item> {
        return listOf(
            Item(
                id = "1",
                title = "Beautiful Landscape",
                description = "A serene view of mountains and a lake at sunset. A great place to relax and enjoy the nature. This is a very long description to test how the UI handles it when the text overflows.",
                imageUrl = "https://example.com/image1.jpg"
            ),
            Item(
                id = "2",
                title = "Modern City",
                description = "The bustling streets of a modern city at night.",
                imageUrl = "https://example.com/image2.jpg"
            ),
            Item(
                id = "3",
                title = "Cozy Cabin",
                description = "A warm and inviting cabin in the snowy woods.",
                imageUrl = "https://example.com/image3.jpg"
            ),
            Item(
                id = "4",
                title = "Desert Dunes",
                description = "Endless sand dunes under a clear blue sky.",
                imageUrl = "https://example.com/image4.jpg"
            ),
            Item(
                id = "5",
                title = "Tropical Beach",
                description = "White sand beach with palm trees and clear water.",
                imageUrl = "https://example.com/image5.jpg"
            )
        )
    }
}