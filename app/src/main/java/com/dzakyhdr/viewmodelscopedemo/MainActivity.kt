package com.dzakyhdr.viewmodelscopedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getUserData()
        mainViewModel.user.observe(this,{ myUser ->
            myUser.forEach {
                Log.i("GetUsers","name is ${it.name}")
            }
        })
    }
}