package com.example.innstantbook.domain

import com.example.innstantbook.networking.ServiceUrl.CLIENTS_GET_URL
import com.example.innstantbook.networking.ServiceUrl.HOTELS_GET_URL
import com.example.innstantbook.networking.ServiceUrl.ROOMS_GET_URL
import com.example.innstantbook.networking.model.ClientResponse
import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.networking.model.RoomResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(HOTELS_GET_URL)
    fun getHotels(): Call<List<HotelResponse>>

    @GET(CLIENTS_GET_URL)
    fun getClients(): Call<List<ClientResponse>>

    @GET(ROOMS_GET_URL)
    fun getRooms(): Call<List<RoomResponse>>
}
