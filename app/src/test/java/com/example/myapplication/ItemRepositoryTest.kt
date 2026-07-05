package com.example.myapplication

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ItemRepositoryTest {

    @Test
    fun `getItems returns expected list of items`() = runTest {
        val repository = ItemRepository()
        val items = repository.getItems()

        assertEquals(20, items.size)
        assertEquals("0", items[0].id)
        assertEquals("Item 0", items[0].title)
        assertEquals("Description for item 0", items[0].description)
    }
}
