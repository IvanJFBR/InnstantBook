package com.example.innstantbook.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.innstantbook.domain.iteractors.GetHotelsIteractor
import com.example.innstantbook.networking.model.HotelsResponse
import com.example.innstantbook.presentation.EventHandler
import com.example.innstantbook.presentation.extensions.launch
import retrofit2.await

class HomeViewModel(private val getHotelsIteractor: GetHotelsIteractor) : ViewModel() {
    private val _homeData = MutableLiveData<List<HotelsResponse>>()
    val homeData: LiveData<List<HotelsResponse>> get() = _homeData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun loadData() = launch {
        getHotelsIteractor().collect { event ->
            EventHandler(event)
                .setOnData {
                    _homeData.value = it
                }
                .setOnError {
                    it
                }
                .setLoading { _loading.value = it }
                .handle()
        }
    }
}