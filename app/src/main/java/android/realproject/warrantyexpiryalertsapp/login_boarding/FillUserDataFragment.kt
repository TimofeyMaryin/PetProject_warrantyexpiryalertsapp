package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.app.Application
import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.user_info.UserEntity
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FillUserDataFragment(
    viewModel: MainViewModel,
    aViewModel: AcquaintanceWithApplicationViewModel,
    modifier: Modifier,
    navController: NavController,
) {

    ConstraintLayout(
        modifier = modifier
    ) {
        val (fillDataPole) = createRefs()

        FillUserData(
            viewModel = aViewModel,
            modifier = Modifier.constrainAs(fillDataPole) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.fillMaxHeight(),
            navController = navController,
            mainViewModel = viewModel
        )




    }
}

@Composable
private fun FillUserData(
    viewModel: AcquaintanceWithApplicationViewModel,
    mainViewModel: MainViewModel,
    modifier: Modifier,
    navController: NavController,
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.Start
    ) {

        item {
            Container {
                Column(
                    modifier =Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    MediumBoldText(text = "Давай добавим аватарку")
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .clickable {  navController.navigate("${Screen.SelectUserPhoto.route}/1") }
                            .border(BorderStroke(1.dp, PRIMARY_70), CircleShape)
                            .size(ApplicationUiConst.SizeObject.IMAGE_SIZE),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = viewModel.avatarUri,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        if(viewModel.avatarUri.isEmpty()) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = null,
                                tint = SURFACE
                            )
                        }
                    }
                }
            }
        }

        item {
            Container {
                Column(
                    modifier =Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    MediumBoldText(text = "Теперь давай установим тебе шапку профиля")
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
                            .fillMaxWidth()
                            .border(BorderStroke(1.dp, PRIMARY_70), RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
                            .clickable {
                                navController.navigate("${Screen.SelectUserPhoto.route}/0")
                            }
                            .height(ApplicationUiConst.SizeObject.HEIGHT_CARD),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = viewModel.headerUri,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        if(viewModel.avatarUri.isEmpty()) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = null,
                                tint = SURFACE
                            )
                        }
                    }
                }
            }
        }

        item {
            Container {
                FillDataTextField(value =  viewModel.firstName, onChangeValue = { viewModel.firstName = it }, placeHolder = "Введи свое имя")
            }
        }
        item {
            Container {
                FillDataTextField(value = viewModel.secondName, onChangeValue = { viewModel.secondName = it }, placeHolder = "Введи свою фамилию")
            }
        }

        item {
            val coroutineScope = rememberCoroutineScope()
            if(
                viewModel.avatarUri.isNotEmpty() &&
                viewModel.firstName.isNotEmpty() &&
                viewModel.secondName.isNotEmpty() &&
                viewModel.headerUri.isNotEmpty()
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            mainViewModel.insertUser(
                                user = UserEntity(
                                    firstName = viewModel.firstName,
                                    secondName = viewModel.secondName,
                                    dateRegister = viewModel.dateOfRegister(),
                                    avatar = viewModel.avatarUri,
                                    headerImage = viewModel.headerUri
                                )
                            )
                            mainViewModel.navController.navigate(Screen.MainScreen.route) {
                                popUpTo(Screen.OnBoarding.route) {
                                    inclusive = true
                                }
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 40.dp)
                        .clip(RoundedCornerShape(0))
                ) {
                    MediumBoldText(text = "Создать аккаунт")
                }

            }

        }

    }
}

@Composable
private fun FillDataTextField(value: String, onChangeValue: (String) -> Unit, placeHolder: String){
    OutlinedTextField(
        value = value,
        onValueChange = { onChangeValue(it) },
        label = { SmallLightText(text = placeHolder) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}