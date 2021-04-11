package com.elixer.paws.android.di

import com.elixer.paws.shared.datasource.network.RecipeService
import com.elixer.paws.shared.datasource.network.RecipeServiceImpl
import com.elixer.paws.shared.datasource.network.model.DogDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeService(): RecipeService {
        return RecipeServiceImpl()
    }

    @Singleton
    @Provides
    fun provideRecipeMapper(): DogDtoMapper {
        return DogDtoMapper()
    }


}