package com.example.innstantbook.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.innstantbook.domain.iteractors.GetClientsIteractor
import com.example.innstantbook.domain.iteractors.GetHotelsIteractor
import com.example.innstantbook.domain.iteractors.GetRoomsIteractor
import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.presentation.EventHandler
import com.example.innstantbook.presentation.extensions.launch

class HomeViewModel(
    private val getHotelsIteractor: GetHotelsIteractor,
    private val getRoomsIteractor: GetRoomsIteractor
) : ViewModel() {
    private val _homeData = MutableLiveData<HomeModel>()
    val homeData: LiveData<HomeModel> get() = _homeData

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    fun loadData() = launch {
        getHotelsIteractor().collect { event ->
            EventHandler(event)
                .setOnData {
                    _homeData.value = HomeModel(hotels = it.takeLast(3), rooms = emptyList())
                }
                .setOnError {
                    it
                }
                .setLoading { _loading.value = it }
                .handle()
        }

        getRoomsIteractor().collect { event ->
            EventHandler(event)
                .setOnData {
                    _homeData.value = HomeModel(
                        hotels = _homeData.value?.hotels ?: emptyList(),
                        rooms = it.takeLast(3)
                    )
                }
                .setOnError {
                    it
                }
                .setLoading { _loading.value = it }
                .handle()
        }
    }
}