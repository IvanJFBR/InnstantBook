package com.example.innstantbook.domain

import com.example.innstantbook.networking.ServiceUrl.HOTELS_GET_URL
import com.example.innstantbook.networking.model.HotelsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(HOTELS_GET_URL)
    fun getHotels(): Call<List<HotelsResponse>>
}
