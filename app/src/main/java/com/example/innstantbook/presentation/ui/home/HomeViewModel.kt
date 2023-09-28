package com.example.innstantbook.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.innstantbook.R
import com.example.innstantbook.presentation.extensions.launch
import com.example.innstantbook.presentation.models.Menu
import com.example.innstantbook.presentation.models.MenuItem
import com.example.innstantbook.presentation.models.MenuType

class HomeViewModel : ViewModel() {
    private val _menu = MutableLiveData<Menu>()
    val menu: LiveData<Menu> get() = _menu

    fun loadData() = launch {

    }
}