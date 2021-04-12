//package com.elixer.paws.android.presentation.ui.dog_detail
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import com.elixer.paws.domain.model.Dog
//import com.elixer.paws.android.util.DEFAULT_DOG_IMAGE
//import com.elixer.paws.android.util.loadPicture
//import com.elixer.paws.presentation.ui.dog_detail.DogDetailViewModel
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//
//@ExperimentalComposeUiApi
//@ExperimentalCoroutinesApi
//@ExperimentalMaterialApi
//@Composable
//fun DogDetailScreen(dog: Dog, viewModel: DogDetailViewModel) {
//
//    Box {
//        val image = loadPicture(url = dog.imageUrl, defaultImage = DEFAULT_DOG_IMAGE).value
//        image?.let { img ->
//            Image(
//                bitmap = img.asImageBitmap(),
//                contentDescription = "Recipe Featured Image",
//                modifier = Modifier
//                    .fillMaxHeight(),
//                contentScale = ContentScale.Crop,
//            )
//        }
//        Column(
//            modifier = Modifier
//                .padding(20.dp)
//                .fillMaxWidth()
//                .fillMaxHeight(),
//
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Spacer(Modifier.weight(1f))
//            Text(
//                text = dog.breed,
//                color = Color.White,
//                style = MaterialTheme.typography.h3,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.Start),
//                fontWeight = FontWeight.Bold
//            )
//
//            Text(
//                text = dog.rating +" ⭐️",
//                color = Color.White,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.Start),
//                style = MaterialTheme.typography.h5,
//            )
//        }
//    }
//
//
//}