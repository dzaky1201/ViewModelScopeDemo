package com.dzakyhdr.viewmodelscopedemo

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User>{
        delay(8000)
        val users: List<User> = listOf(
                User(1,"Dzaky"),
                User(2,"Haidar"),
                User(3,"Indonesia"),
                User(4,"Negara")
        )

        return users
    }
}