package com.example.exam8.common.resource

sealed class Resource<T> {
    data class Success<T>(val list: Any?) : Resource<T>()
    data class Error<T>(val errorMsg: String) : Resource<T>()
}