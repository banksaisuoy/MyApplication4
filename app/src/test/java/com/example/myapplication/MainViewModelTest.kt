package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var repository: ItemRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mock()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadItems updates items LiveData with data from repository`() = runTest {
        val testData = listOf(Item("1", "Test 1", "Desc 1"))
        whenever(repository.getItems()).thenReturn(testData)

        viewModel = MainViewModel(repository) // init calls loadItems

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(testData, viewModel.items.value)
        assertEquals(false, viewModel.isLoading.value)
        assertEquals(null, viewModel.error.value)
    }

    @Test
    fun `loadItems updates error LiveData when repository throws`() = runTest {
        val exceptionMessage = "Network error"
        whenever(repository.getItems()).thenThrow(RuntimeException(exceptionMessage))

        viewModel = MainViewModel(repository)

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(exceptionMessage, viewModel.error.value)
        assertEquals(false, viewModel.isLoading.value)
        assertEquals(null, viewModel.items.value)
    }
}
