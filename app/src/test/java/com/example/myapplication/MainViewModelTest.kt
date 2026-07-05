package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchItems should update LiveData with mock data`() = runTest {
        // Arrange
        val viewModel = MainViewModel()

        // Act
        viewModel.fetchItems()
        advanceUntilIdle() // Wait for coroutine delay to finish

        // Assert
        val items = viewModel.items.value
        assertEquals(20, items?.size)
        assertEquals("1", items?.first()?.id)
        assertEquals("Product 1", items?.first()?.title)
    }
}
