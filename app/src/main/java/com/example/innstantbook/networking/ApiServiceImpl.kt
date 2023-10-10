package com.example.innstantbook.networking

import com.example.innstantbook.domain.ApiService
import com.example.innstantbook.networking.model.ClientResponse
import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.networking.model.RoomResponse
import retrofit2.Call

class ApiServiceImpl() : ApiService {
     override fun getHotels(): Call<List<HotelResponse>> =
        services().getHotels()

    override fun getClients(): Call<List<ClientResponse>> =
        services().getClients()

    override fun getRooms(): Call<List<RoomResponse>> =
        services().getRooms()
}