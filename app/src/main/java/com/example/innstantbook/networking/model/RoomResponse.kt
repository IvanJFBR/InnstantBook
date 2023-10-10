package com.example.innstantbook.networking.model

import com.google.gson.annotations.SerializedName

data class RoomResponse(
    @SerializedName("id")
    val cpf: Int,
    @SerializedName("numero")
    val number: Int,
    @SerializedName("preco")
    val price: Float,
    @SerializedName("status")
    val status: Int,
    @SerializedName("hotelCNPJ")
    val hotelCNPJ: String
)