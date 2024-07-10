package com.example.myapplication.data.datasource

import com.example.myapplication.data.network.ClientServices
import com.example.myapplication.data.network.responses.Response
import javax.inject.Inject

class ClientDataSource @Inject constructor(
    private val service: ClientServices
){
    suspend fun fetchClients(): Response {
        return service.getClients()
    }
}