package com.example.myapplication.data.repositories

import com.example.myapplication.data.datasource.ClientDataSource
import com.example.myapplication.data.domain.Client
import com.example.myapplication.data.network.responses.toModel
import javax.inject.Inject

class ClientRepository @Inject constructor(
    private val clientDataSource: ClientDataSource
) {
    suspend fun fetchClient(): List<Client> {
        val data = clientDataSource
            .fetchClients()
            .clientsData.map { item -> item.toModel() }
        print(data)

        return data
    }
}