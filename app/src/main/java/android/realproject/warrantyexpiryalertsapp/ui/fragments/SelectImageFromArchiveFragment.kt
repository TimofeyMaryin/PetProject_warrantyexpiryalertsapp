package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.media.ImageReader
import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.LoadingShimmerEffect
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.utils.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.google.android.material.progressindicator.CircularProgressIndicator

@Composable
fun SelectImageFromArchiveFragment(
    viewModel: CreateUserProductViewModel,
    navController: NavController
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val context = LocalContext.current
        val checkInternetState by remember {
            mutableStateOf(checkInternetConnection(context))
        }
        val (header, content) = createRefs()
        SmallApplicationHeader(
            titlePreviousFragment = "Создать",
            titleCurrentFragment = "Выбор изображения",
            navController = navController,
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        if(checkInternetState) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.constrainAs(content){
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ){
                items(IMAGE_ARCHIVE.size) {
                    Container {
                        Box(
                            modifier = Modifier
                                .size(ApplicationUiConst.SizeObject.IMAGE_SIZE)
                                .clip(
                                    RoundedCornerShape(ApplicationUiConst.Rounded.VERY_SMALL),
                                )
                                .clickable {
                                    viewModel.imageModel = IMAGE_ARCHIVE[it]
                                    navController.popBackStack()
                                },
                            contentAlignment = Alignment.Center,
                        ) {
                            SubcomposeAsyncImage(
                                model = IMAGE_ARCHIVE[it],
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
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
                }

            }

        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "No Internet connection")
            }
        }
    }

}