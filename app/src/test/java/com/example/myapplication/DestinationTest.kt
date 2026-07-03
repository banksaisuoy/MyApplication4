package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

class DestinationTest {
    @Test
    fun destinationCreation_isCorrect() {
        val dest = Destination("1", "Test City", "Test Description")
        assertEquals("1", dest.id)
        assertEquals("Test City", dest.name)
        assertEquals("Test Description", dest.description)
    }

    @Test
    fun mockDataList_hasCorrectSize() {
        val destinations = listOf(
            Destination("1", "Paris, France", "The city of love and lights. Experience the Eiffel Tower, the Louvre, and fine dining."),
            Destination("2", "Kyoto, Japan", "Discover ancient temples, traditional tea houses, and beautiful cherry blossoms."),
            Destination("3", "New York City, USA", "The city that never sleeps. Explore Times Square, Central Park, and Broadway."),
            Destination("4", "Rome, Italy", "Step back in time with the Colosseum, the Pantheon, and authentic Italian cuisine."),
            Destination("5", "Sydney, Australia", "Enjoy the iconic Opera House, Bondi Beach, and vibrant harbor life.")
        )
        assertEquals(5, destinations.size)
    }
}