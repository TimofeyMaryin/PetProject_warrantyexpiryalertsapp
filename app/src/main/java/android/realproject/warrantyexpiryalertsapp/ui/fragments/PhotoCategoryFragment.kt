package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.model.PhotoCategoryModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.LoadingShimmerEffect
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.realproject.warrantyexpiryalertsapp.utils.PHOTO_CATEGORY
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun PhotoCategoryFragment(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SmallApplicationHeader(
            titlePreviousFragment = "Выбор фото",
            titleCurrentFragment = "Категории",
            navController = navController
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(PHOTO_CATEGORY.size){
                PhotoCategoryItem(model = PHOTO_CATEGORY[it], navController = navController)
            }
        }
    }
}

@Composable
private fun PhotoCategoryItem(
    model: PhotoCategoryModel,
    navController: NavController
) {
    Container {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable {
                navController.navigate("${Screen.SelectImageFromArchiveScreen.route}/${model.title}")
                Log.e("PhotoCategoryItem", "model.title: ${model.title}", )
            }
        ) {
            SubcomposeAsyncImage(
                model = model.image,
                contentDescription = null,
                modifier = Modifier
                    .size(ApplicationUiConst.SizeObject.IMAGE_SIZE)
                    .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL)),
                contentScale = ContentScale.Crop
            ) {
                val state = painter.state
                if(state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                    LoadingShimmerEffect(modifier = Modifier.size(ApplicationUiConst.SizeObject.IMAGE_SIZE))
                } else {
                    SubcomposeAsyncImageContent()
                }
            }

            SmallLightText(text = model.title)
        }
    }
}