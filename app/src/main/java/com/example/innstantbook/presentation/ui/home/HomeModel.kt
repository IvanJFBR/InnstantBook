package com.example.innstantbook.presentation.ui.home

import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.networking.model.RoomResponse

data class HomeModel(
    val hotels: List<HotelResponse>,
    val rooms: List<RoomResponse>
)
