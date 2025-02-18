package com.mihudevcom.androidplayground.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName: LiveData<String> get() = _userName

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    fun setUserData(name: String, email: String) {
        _userName.value = name
        _email.value = email
    }
}