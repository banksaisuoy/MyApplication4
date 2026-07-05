package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
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
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: MainViewModel
    private val repository = ItemRepository() // Using actual repo since it just delays and returns mocked data

    @Mock
    private lateinit var itemsObserver: Observer<List<Item>>

    @Mock
    private lateinit var loadingObserver: Observer<Boolean>

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun loadItems_updatesLiveData() = runTest {
        // Initialize viewmodel after main dispatcher is set so the initial load is on the test dispatcher
        viewModel = MainViewModel(repository)
        viewModel.items.observeForever(itemsObserver)
        viewModel.isLoading.observeForever(loadingObserver)

        // Advance time to allow the initial delay in repository to complete
        testDispatcher.scheduler.advanceUntilIdle()

        // Verify that loading was true, then false
        verify(loadingObserver).onChanged(true)
        verify(loadingObserver).onChanged(false)

        // Verify items were loaded
        val items = viewModel.items.value
        assertEquals(4, items?.size)
        assertEquals("Fix Layout Bugs", items?.get(0)?.title)

        viewModel.items.removeObserver(itemsObserver)
        viewModel.isLoading.removeObserver(loadingObserver)
    }
}
