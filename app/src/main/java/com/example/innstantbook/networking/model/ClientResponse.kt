package com.example.innstantbook.networking.model

import com.google.gson.annotations.SerializedName

data class ClientResponse(
    @SerializedName("cnpj")
    val cpf: String,
    @SerializedName("nome")
    val name: String,
    @SerializedName("email")
    val email: String
)