package com.elixer.paws.shared.datasource.network

import com.elixer.paws.shared.datasource.network.model.DogDto
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class RecipeServiceImpl: RecipeService {

    private val BASE_URL = "https://dog.ceo/api/"

    private val client: HttpClient = HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true // if the server sends extra fields, ignore them
            })
        }
    }

    override suspend fun getDogs(): DogDto {
        return client.get<DogDto>("$BASE_URL/breeds/image/random/4"){
        }
    }
}







