package com.elixer.paws.android.presentation.ui.dog_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elixer.paws.shared.domain.model.Dog
import com.elixer.paws.shared.interactors.dog_list.GetDogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DogListViewModel @Inject constructor(private val getDogs: GetDogs) : ViewModel() {

    val recipes: MutableState<List<Dog>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)

    init {
        loadMore()
    }

    internal fun loadMore() {
        // prevent duplicate event due to recompose happening to quickly
        loading.value = true
        getDogs.execute().onEach { dataState ->
            loading.value = dataState.loading

            dataState.data?.let { list ->
                appendDogs(list)
            }

            dataState.error?.let { error ->
                Log.e("TAG", "newSearch: ${error}")
            }

        }.launchIn(viewModelScope)
    }

    /**
     * Append new recipes to the current list of recipes
     */
    private fun appendDogs(recipes: List<Dog>) {
        val current = ArrayList(this.recipes.value)
        current.addAll(recipes)
        this.recipes.value = current
    }
}





















