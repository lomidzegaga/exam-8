package com.example.exam8.common.base

import com.example.exam8.common.resource.Resource
import retrofit2.Response

abstract class BaseHandler {

    suspend fun <T: Any> apiCall(request: suspend () -> Response<T>) : Resource<T> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                Resource.Success(response.body())
            } else {
                Resource.Error(response.errorBody()!!.string())
            }
        } catch (e: Throwable) {
            Resource.Error(e.message ?: "")
        }
    }

}