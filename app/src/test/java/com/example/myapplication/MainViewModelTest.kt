package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
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
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.argumentCaptor

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var itemsObserver: Observer<List<ItemData>>

    @Mock
    private lateinit var loadingObserver: Observer<Boolean>

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = MainViewModel()
        viewModel.items.observeForever(itemsObserver)
        viewModel.isLoading.observeForever(loadingObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        viewModel.items.removeObserver(itemsObserver)
        viewModel.isLoading.removeObserver(loadingObserver)
    }

    @Test
    fun `loadData sets loading true then updates items and sets loading false`() = runTest(testDispatcher) {
        viewModel.loadData()

        advanceUntilIdle()

        val loadingCaptor = argumentCaptor<Boolean>()
        verify(loadingObserver, times(2)).onChanged(loadingCaptor.capture())

        val values = loadingCaptor.allValues
        assertEquals(2, values.size)
        assertEquals(true, values[0])
        assertEquals(false, values[1])

        val itemsCaptor = argumentCaptor<List<ItemData>>()
        verify(itemsObserver).onChanged(itemsCaptor.capture())

        val items = itemsCaptor.firstValue
        assertEquals(5, items.size)
        assertEquals("1", items[0].id)
        assertEquals("Item 1", items[0].name)
    }
}
