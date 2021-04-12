package com.elixer.paws.shared.datasource.network

import com.elixer.paws.shared.datasource.network.model.DogDto

interface DogService {

    suspend fun getDogs(): DogDto


}