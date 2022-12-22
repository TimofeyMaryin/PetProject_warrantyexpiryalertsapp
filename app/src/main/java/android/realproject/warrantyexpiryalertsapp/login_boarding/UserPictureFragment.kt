package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.LoadingShimmerEffect
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun UserPictureFragment(
    navController: NavController,
    aViewModel: AcquaintanceWithApplicationViewModel,
    forAvatarImage: String,
    titleCurrentFragment: String
) {
    val currentListImage by remember {
        mutableStateOf(if(forAvatarImage != "0") aViewModel.avatarImages else aViewModel.headerImages)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SmallApplicationHeader(
            titlePreviousFragment = "Select image",
            titleCurrentFragment = titleCurrentFragment,
            navController = navController
        )

        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(currentListImage.size) {
                 PhotoCItem(
                     url = currentListImage[it],
                     navController = navController
                 ) {
                     if(forAvatarImage != "0") {
                         aViewModel.avatarUri = currentListImage[it]
                     } else {
                         aViewModel.headerUri = currentListImage[it]
                     }
                 }
            }
        }
    }
}


@Composable
private fun PhotoCItem(
    url: String,
    navController: NavController,
    onClickAction: () -> Unit
) {
    Container {
        SubcomposeAsyncImage(
            model = url,
            contentDescription = null,
            modifier = Modifier
                .size(ApplicationUiConst.SizeObject.IMAGE_SIZE)
                .clip(
                    RoundedCornerShape(ApplicationUiConst.Rounded.SMALL)
                )
                .clickable {
                    navController.popBackStack()
                    onClickAction()
                },
            contentScale = ContentScale.Crop
        ) {
            val state = painter.state
            if(state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                LoadingShimmerEffect(modifier = Modifier.size(ApplicationUiConst.SizeObject.IMAGE_SIZE))
            } else {
                SubcomposeAsyncImageContent()
            }
        }
    }
}