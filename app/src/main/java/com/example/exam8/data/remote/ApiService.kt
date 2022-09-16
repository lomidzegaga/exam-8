package com.example.exam8.data.remote

import com.example.exam8.common.constants.ApiEndpoints
import com.example.exam8.data.model.ItemsDto
import com.example.exam8.domain.model.Items
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ApiEndpoints.END_POINT)
    suspend fun getItems() : Response<ItemsDto>

}