package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ItemRepository = ItemRepository()) : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        loadItems()
    }

    fun loadItems() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _items.value = repository.getItems()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
