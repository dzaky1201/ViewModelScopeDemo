package com.dzakyhdr.viewmodelscopedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private var userRepository = UserRepository()
    private var _users: MutableLiveData<List<User>> = MutableLiveData()
    val user: LiveData<List<User>>
        get() = _users

    fun getUserData() {
        viewModelScope.launch {
            var result: List<User>?
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }

            _users.value = result
        }
    }
}