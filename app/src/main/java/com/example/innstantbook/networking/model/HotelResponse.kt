package com.example.innstantbook.networking.model

import com.google.gson.annotations.SerializedName

data class HotelResponse(
    @SerializedName("cnpj")
    val cnpj: String,
    @SerializedName("nome")
    val name: String,
    @SerializedName("endereco")
    val address: String,
    @SerializedName("mediaAvaliacao")
    val score: String,
    @SerializedName("quantidadeAvaliacoes")
    val ratingQuantity: String,
    @SerializedName("quartosDisponiveis")
    val availableRooms: String
)