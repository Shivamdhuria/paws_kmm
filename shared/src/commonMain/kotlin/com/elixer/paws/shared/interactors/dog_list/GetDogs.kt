package com.elixer.paws.shared.interactors.dog_list

import com.elixer.paws.shared.datasource.network.RecipeService
import com.elixer.paws.shared.datasource.network.model.DogDtoMapper
import com.elixer.paws.shared.domain.data.DataState
import com.elixer.paws.shared.domain.model.Dog
import com.elixer.paws.shared.domain.util.CommonFlow
import com.elixer.paws.shared.domain.util.asCommonFlow
import kotlinx.coroutines.flow.flow

class GetDogs(private val recipeService: RecipeService, private val dtoMapper: DogDtoMapper) {

    fun execute(): CommonFlow<DataState<List<Dog>>> = flow {
        try {
            emit(DataState.loading())
            val dogs = getDogsFromNetwork()
            emit(DataState.success(dogs))
        } catch (e: Exception) {
            emit(DataState.error<List<Dog>>(e.message ?: "Unknown Error"))
        }
    }.asCommonFlow()

    private suspend fun getDogsFromNetwork(): List<Dog> {
        val dogDtos = recipeService.getDogs().message
        return dtoMapper.toDomainList(dogDtos)
    }
}