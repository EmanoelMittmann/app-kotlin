package com.example.myapplication.data.network.responses

import com.example.myapplication.data.domain.Client
import com.google.gson.annotations.SerializedName
import java.util.UUID

data class ClientsResponse (
    @SerializedName("uuid")
    val uuid: UUID,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("cpf")
    val cpf: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("isEnabled")
    val isEnabled: Boolean
)

fun ClientsResponse.toModel() = Client(
    uuid = this.uuid,
    name = this.name,
    email = this.email,
    cpf = this.cpf,
    photo = this.photo,
    isEnabled = this.isEnabled,
)
