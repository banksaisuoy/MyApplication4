package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel
    private lateinit var repository: ItemRepository

    @Before
    fun setup() {
        repository = ItemRepository()
        viewModel = MainViewModel(repository)
    }

    @Test
    fun loadItems_populatesItemsLiveData() {
        viewModel.loadItems()

        val items = viewModel.items.value
        assertEquals(5, items?.size)
        assertEquals("Beautiful Landscape", items?.get(0)?.title)
        assertEquals("Modern City", items?.get(1)?.title)
    }
}