package com.example.exam8.ui

import androidx.lifecycle.ViewModel
import com.example.exam8.common.resource.Resource
import com.example.exam8.data.model.ItemsDto
import com.example.exam8.domain.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    fun items(): Flow<Resource<ItemsDto>> = flow {
        emit(itemsRepository.getUsers())
    }
}