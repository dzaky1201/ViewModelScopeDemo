package com.dzakyhdr.viewmodelscopedemo

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private var userRepository = UserRepository()

    var users = liveData(Dispatchers.IO) {
        val result = userRepository.getUsers()
        emit(result)
    }
//    private var _users: MutableLiveData<List<User>> = MutableLiveData()
//    val user: LiveData<List<User>>
//        get() = _users
//
//    fun getUserData() {
//        viewModelScope.launch {
//            var result: List<User>?
//            withContext(Dispatchers.IO){
//                result = userRepository.getUsers()
//            }
//
//            _users.value = result
//        }
//    }
}