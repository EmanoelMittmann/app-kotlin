package com.example.myapplication.data.network.responses

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val clientsData: List<ClientsResponse>
)