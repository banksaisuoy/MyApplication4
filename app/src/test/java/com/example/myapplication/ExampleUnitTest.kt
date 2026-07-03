package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun dataProvider_returnsCorrectNumberOfItems() {
        val items = DataProvider.getItems()
        assertEquals(5, items.size)
    }

    @Test
    fun dataProvider_returnsValidItems() {
        val items = DataProvider.getItems()
        assertTrue(items.isNotEmpty())
        assertEquals("Item 1", items[0].title)
        assertEquals("Description for Item 1", items[0].description)
        assertEquals(1, items[0].id)
    }
}
