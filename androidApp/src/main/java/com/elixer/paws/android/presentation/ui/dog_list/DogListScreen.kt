package com.elixer.paws.android.presentation.ui.dog_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.elixer.paws.android.presentation.components.DogItemCard
import com.elixer.paws.android.presentation.theme.PawsTheme
import com.elixer.paws.shared.domain.model.Dog
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun DogListScreen(viewModel: DogListViewModel, navController: NavController) {

    val dogs = viewModel.recipes.value

    PawsTheme() {
        Box() {
            Column(modifier = Modifier.padding(bottom = 10.dp)) {
                TopAppBar(title = { Text(text = "Dog List") })
                DogList(dogs = dogs)
            }

            Column() {
                Spacer(Modifier.weight(1f))
                Button(onClick = { viewModel.loadMore() }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Load More")

                }
            }
        }

    }
}

@Composable
fun DogList(dogs: List<Dog>) {
    LazyColumn {
        this.items(dogs) { dog ->
            DogItemCard(dog,
                onClick = {}
            )
        }
    }
}