package com.example.myapplication.commons

sealed class RequestStatus<out T> {
    data object Loading: RequestStatus<Nothing>()
    data class Sucess<out T>(val data: T): RequestStatus<T>()
    data class Error(val exception: Exception): RequestStatus<Nothing>()
}