package com.example.myapplication.data.domain

import java.io.Serializable
import java.util.UUID

data class Client(
    val uuid: UUID,
    val name: String,
    val email: String,
    val cpf: String,
    val photo: String,
    val isEnabled: Boolean
): Serializable

fun Client.ToDomain() = Client(
    uuid = this.uuid,
    name = this.name,
    email = this.email,
    cpf = this.cpf,
    photo = this.photo,
    isEnabled = this.isEnabled,
)
