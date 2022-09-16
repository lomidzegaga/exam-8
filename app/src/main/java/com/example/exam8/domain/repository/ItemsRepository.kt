package com.example.exam8.domain.repository

import com.example.exam8.common.resource.Resource
import com.example.exam8.data.model.ItemsDto
import com.example.exam8.data.remote.ApiService
import javax.inject.Inject

class ItemsRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getUsers(): Resource<ItemsDto> {
        return try {
            val response = apiService.getItems()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

}