package com.elixer.paws.shared.datasource.network

import com.elixer.paws.shared.datasource.network.model.DogDto

interface RecipeService {

    suspend fun getDogs(): DogDto


}