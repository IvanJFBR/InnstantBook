package com.example.innstantbook.networking

import com.example.innstantbook.domain.ApiService
import com.example.innstantbook.networking.model.HotelsResponse
import retrofit2.Call
import retrofit2.Response

class ApiServiceImpl() : ApiService {
     override fun getHotels(): Call<List<HotelsResponse>> =
        services().getHotels()
}