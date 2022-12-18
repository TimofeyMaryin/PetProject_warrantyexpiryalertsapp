package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.app.Application
import android.media.ImageReader
import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.LoadingShimmerEffect
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.utils.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.google.android.material.progressindicator.CircularProgressIndicator
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectImageFromArchiveFragment(
    viewModel: CreateUserProductViewModel,
    navController: NavController
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.7f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MediumBoldText(
                    text = "Вы уверены в выборе фотографии?",
                    modifier = Modifier.padding(vertical = ApplicationUiConst.Padding.LARGE),
                    textAlign = TextAlign.Center
                )
                AsyncImage(
                    model = viewModel.imageModel,
                    contentDescription =  null,
                    modifier = Modifier.fillMaxWidth().height(300.dp),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                bottomSheetScaffoldState.bottomSheetState.collapse()
                            }
                            viewModel.imageModel = null
                            navController.popBackStack()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFFEE747F),
                            contentColor = PRIMARY
                        ),
                        modifier = Modifier.fillMaxWidth(.4f)
                    ) {
                        SmallLightText(text = "Отмена")
                    }

                    Button(
                        onClick = {
                            coroutineScope.launch {
                                bottomSheetScaffoldState.bottomSheetState.collapse()
                            }
                            navController.popBackStack()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = SECONDARY,
                            contentColor = PRIMARY
                        ),
                        modifier = Modifier.fillMaxWidth(.4f)
                    ) {
                        SmallLightText(text = "Выбрать")
                    }
                }
            }
        }, sheetPeekHeight = 0.dp
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
                                        //navController.popBackStack()

                                        coroutineScope.launch {
                                            if(bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                                bottomSheetScaffoldState.bottomSheetState.expand()
                                            } else {
                                                bottomSheetScaffoldState.bottomSheetState.collapse()
                                            }
                                        }

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


}