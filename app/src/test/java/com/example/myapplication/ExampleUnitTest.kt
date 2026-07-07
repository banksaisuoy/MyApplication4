package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun dataProvider_returnsCorrectNumberOfItems() {
        val data = DataProvider.getMockData()
        assertEquals(100, data.size)
    }

    @Test
    fun dataProvider_itemsHaveCorrectContent() {
        val data = DataProvider.getMockData()
        val firstItem = data.first()
        val lastItem = data.last()

        assertEquals("Item 0", firstItem.title)
        assertEquals("Description for item 0", firstItem.description)

        assertEquals("Item 99", lastItem.title)
        assertEquals("Description for item 99", lastItem.description)
    }
}