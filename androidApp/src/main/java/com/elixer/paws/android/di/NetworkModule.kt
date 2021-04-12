package com.elixer.paws.android.di

import com.elixer.paws.shared.datasource.network.DogService
import com.elixer.paws.shared.datasource.network.DogServiceImpl
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
    fun provideRecipeService(): DogService {
        return DogServiceImpl()
    }

    @Singleton
    @Provides
    fun provideRecipeMapper(): DogDtoMapper {
        return DogDtoMapper()
    }


}