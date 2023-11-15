package com.example.midterm2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.midterm2.repository.DataLoaderRepository
import com.example.midterm2.repository.User

class DataLoaderViewModel : ViewModel() {
    private val repository = DataLoaderRepository()
    private val _liveDataUsers = MutableLiveData<List<User>>()
    val liveDataUsers: LiveData<List<User>> = _liveDataUsers

    fun loadUsers() {
        viewModelScope.launch {
            _liveDataUsers.postValue(repository.loadUsers())
        }
    }
}