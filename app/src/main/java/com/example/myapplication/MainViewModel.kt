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

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        loadItems()
    }

    fun loadItems() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val data = repository.getItems()
                _items.value = data
            } catch (e: Exception) {
                _error.value = e.message ?: "An unknown error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
