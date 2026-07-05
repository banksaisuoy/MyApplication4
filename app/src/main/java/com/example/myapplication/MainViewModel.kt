package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    init {
        fetchItems()
    }

    fun fetchItems() {
        viewModelScope.launch {
            // Simulate network delay
            delay(500)
            _items.value = getMockData()
        }
    }

    private fun getMockData(): List<Item> {
        val list = mutableListOf<Item>()
        for (i in 1..20) {
            list.add(
                Item(
                    id = i.toString(),
                    title = "Product $i",
                    description = "This is a detailed description for product $i, ensuring high quality content.",
                    imageUrl = "https://example.com/image$i.png"
                )
            )
        }
        return list
    }
}
