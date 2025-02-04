package com.mihudevcom.androidplayground.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BadgeViewModel : ViewModel() {

    private val _badgeCount = MutableLiveData(0)
    val badgeCount: LiveData<Int> get() = _badgeCount

    fun updateBadge(count: Int) {
        _badgeCount.value = count
    }
}