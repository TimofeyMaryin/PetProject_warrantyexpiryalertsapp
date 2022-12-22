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
    val coroutineScope = rememberCoroutineScope()

    ConstraintLayout(
        modifier = modifier
    ) {
        val (title, fillDataPole, buttonCreate) = createRefs()

        ContainWithLottie(
            title = "Lets start fill your person data",
            resAnim = R.raw.anim_icon,
            modifier = Modifier.constrainAs(title){
                top.linkTo(parent.top, margin = ApplicationUiConst.Padding.BIG)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(fillDataPole.top)
            }.fillMaxHeight(.4f)
        )
        FillUserData(
            viewModel = aViewModel,
            modifier = Modifier.constrainAs(fillDataPole) {
                top.linkTo(title.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }.fillMaxHeight(),
            navController = navController,
        )
        if(
            aViewModel.avatarUri.isNotEmpty() &&
            aViewModel.firstName.isNotEmpty() &&
            aViewModel.secondName.isNotEmpty() &&
            aViewModel.headerUri.isNotEmpty()
        ) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.insertUser(
                            user = UserEntity(
                                firstName = aViewModel.firstName,
                                secondName = aViewModel.secondName,
                                dateRegister = aViewModel.dateOfRegister(),
                                avatar = aViewModel.avatarUri,
                                headerImage = aViewModel.headerUri
                            )
                        )
                        viewModel.navController.navigate(Screen.MainScreen.route) {
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
                    .constrainAs(buttonCreate) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
            ) {
                MediumBoldText(text = "Create Account")
            }

        }



    }
}

@Composable
private fun FillUserData(
    viewModel: AcquaintanceWithApplicationViewModel,
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
                    MediumBoldText(text = "First step: Add avatar")
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
                    MediumBoldText(text = "Next step: Add header image")
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
                FillDataTextField(value =  viewModel.firstName, onChangeValue = { viewModel.firstName = it }, placeHolder = "Enter your first name")
            }
        }
        item {
            Container {
                FillDataTextField(value = viewModel.secondName, onChangeValue = { viewModel.secondName = it }, placeHolder = "Enter your second name")
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