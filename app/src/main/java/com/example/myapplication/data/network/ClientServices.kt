package com.example.myapplication.data.network

import com.example.myapplication.data.network.responses.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ClientServices {
    @Headers("Content_Type: application/json")
    @GET("clients?page=1&size=20")
    suspend fun getClients(): Response
}