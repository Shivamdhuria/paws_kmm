package com.elixer.paws.android.di

import com.elixer.paws.shared.datasource.network.DogService
import com.elixer.paws.shared.datasource.network.model.DogDtoMapper
import com.elixer.paws.shared.interactors.dog_list.GetDogs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {

    @ViewModelScoped
    @Provides
    fun provideGetDogs(recipeService: DogService, dtoMapper: DogDtoMapper, ) =
        GetDogs(recipeService = recipeService, dtoMapper)
//
//  @ViewModelScoped
//  @Provides
//  fun provideRestoreRecipes(
//    recipeDao: RecipeDao,
//    recipeEntityMapper: RecipeEntityMapper,
//  ): RestoreRecipes {
//    return RestoreRecipes(
//      recipeDao = recipeDao,
//      entityMapper = recipeEntityMapper,
//    )
//  }
//
//  @ViewModelScoped
//  @Provides
//  fun provideGetRecipe(
//    recipeDao: RecipeDao,
//    recipeEntityMapper: RecipeEntityMapper,
//    recipeService: RecipeService,
//    recipeDtoMapper: RecipeDtoMapper,
//  ): GetRecipe {
//    return GetRecipe(
//      recipeDao = recipeDao,
//      entityMapper = recipeEntityMapper,
//      recipeService = recipeService,
//      recipeDtoMapper = recipeDtoMapper,
//    )
//  }

}











