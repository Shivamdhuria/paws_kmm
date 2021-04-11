package com.elixer.paws.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elixer.paws.android.presentation.navigation.Screen
import com.elixer.paws.android.presentation.theme.PawsTheme
import com.elixer.paws.android.presentation.ui.dog_list.DogListScreen
import com.elixer.paws.android.presentation.ui.dog_list.DogListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalCoroutinesApi
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawsTheme {
                setContent {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.DogList.route
                    ) {
//                        composable(route = Screen.DogDetail.route + "/{dog}",
//                            arguments = listOf(navArgument("dog") {
//                                type = NavType.StringType
//                            })
//                        ) { navBackStackEntry ->
//                            val factory =
//                                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
//                            val viewModel =
//                                viewModel<DogDetailViewModel>("DogDetailViewModel", factory)
//                            navBackStackEntry.arguments?.getString("dog")?.let { json->
//                                val dog = Gson().fromJson(json, Dog::class.java)
//                                DogDetailScreen(
//                                    dog = dog,
//                                    viewModel = viewModel,
//                                )
//                            }
//
//                        }

                        composable(
                            route = Screen.DogList.route
                        ) { navBackStackEntry ->
                            val factory =
                                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                            val viewModel: DogListViewModel = viewModel("DogListViewModel", factory)
                            DogListScreen(
                                viewModel = viewModel,
                                navController = navController,
                            )
                        }


                    }

                }
            }
        }
    }
}
