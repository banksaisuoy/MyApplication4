package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _items = MutableLiveData<List<ItemData>>()
    val items: LiveData<List<ItemData>> = _items

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadData() {
        _isLoading.value = true
        // Simulate network request
        viewModelScope.launch {
            delay(1000) // Mock delay
            val mockData = listOf(
                ItemData("1", "Item 1", "Description for item 1"),
                ItemData("2", "Item 2", "Description for item 2"),
                ItemData("3", "Item 3", "Description for item 3"),
                ItemData("4", "Item 4", "Description for item 4"),
                ItemData("5", "Item 5", "Description for item 5")
            )
            _items.value = mockData
            _isLoading.value = false
        }
    }
}
