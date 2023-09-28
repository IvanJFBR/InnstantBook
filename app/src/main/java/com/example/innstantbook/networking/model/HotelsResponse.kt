package com.example.innstantbook.networking.model

import com.google.gson.annotations.SerializedName

data class HotelsResponse(
    @SerializedName("cnpj")
    val cnpj: String,
    @SerializedName("nome")
    val name: String,
    @SerializedName("endereco")
    val address: String
)