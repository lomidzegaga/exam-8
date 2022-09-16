package com.example.exam8.data.model

import com.example.exam8.domain.model.Items

data class ItemsDto(
    val dataDtoItems: List<DataDtoItem>
) {
    data class DataDtoItem(
        val cover: String,
        val liked: Boolean,
        val price: String,
        val title: String
    )
}

fun ItemsDto.DataDtoItem.toItems() : Items {
    return Items(
        cover = cover,
        price = price,
        title = title
    )
}