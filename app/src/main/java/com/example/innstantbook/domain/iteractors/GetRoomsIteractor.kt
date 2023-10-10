package com.example.innstantbook.domain.iteractors

import com.example.innstantbook.domain.ApiService
import com.example.innstantbook.extensions.executeCompleteFlowEvent
import com.example.innstantbook.networking.model.ClientResponse
import com.example.innstantbook.networking.model.HotelResponse
import com.example.innstantbook.networking.model.RoomResponse
import com.example.innstantbook.shared.Event
import kotlinx.coroutines.flow.Flow
import retrofit2.await

class GetRoomsIteractor(private val service: ApiService) {
    operator fun invoke(): Flow<Event<List<RoomResponse>>> =
        executeCompleteFlowEvent(
            getData = { service.getRooms().await() })
}