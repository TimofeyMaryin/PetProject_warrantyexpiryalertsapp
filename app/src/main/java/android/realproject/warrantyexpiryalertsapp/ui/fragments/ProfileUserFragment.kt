package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.app.Application
import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.user_info.UserEntity
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.login_boarding.AcquaintanceWithApplicationViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.ApplicationTextField
import android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog.AlertChangeUserImage
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.*
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.service.autofill.UserData
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

@Composable
fun ProfileUserFragment(
    viewModel: MainViewModel,
    navController: NavController,
    aViewModel: AcquaintanceWithApplicationViewModel,
){
    val context = LocalContext.current
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (
            cardImage, avatar,
            personData, exitButton,
            textFields, bottomBar
        ) = createRefs()


        if(
            viewModel.getUser() != null
        ) {
            // Image for header
            if(viewModel.getUser().headerImage != null && viewModel.getUser().headerImage != "") {
                AsyncImage(
                    model = viewModel.getUser().headerImage,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ApplicationUiConst.SizeObject.HEIGHT_CARD)
                        .constrainAs(cardImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop
                )

            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(PRIMARY_70)
                        .height(ApplicationUiConst.SizeObject.HEIGHT_CARD)
                        .constrainAs(cardImage) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                    }
                )
            }
            // Avatar
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(BACKGROUND)
                    .border(BorderStroke(5.dp, BACKGROUND), CircleShape)
                    .clickable { viewModel.openAlertChangeUserPhoto = true }
                    .size(ApplicationUiConst.SizeObject.AVATAR_SIZE)
                    .constrainAs(avatar) {
                        top.linkTo(cardImage.bottom, margin = (-65).dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentAlignment = Alignment.Center,
            ) {
                if(viewModel.getUser().avatar != null || viewModel.getUser().avatar != ""){
                    AsyncImage(
                        model = viewModel.getUser().avatar,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.default_avatar),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(.93f)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }

            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(ApplicationUiConst.SizeObject.HEIGHT_CARD)
                    .background(PRIMARY)
                    .constrainAs(cardImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable {
                        viewModel.openAlertChangeUserPhoto = true
                    }
                    .background(BACKGROUND)
                    .size(ApplicationUiConst.SizeObject.AVATAR_SIZE)
                    .constrainAs(avatar) {
                        top.linkTo(cardImage.bottom, margin = (-65).dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.default_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(.93f)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

            }

        }


        PrivateUserData(
            modifier = Modifier.constrainAs(personData) {
                top.linkTo(avatar.bottom, margin = ApplicationUiConst.Padding.NORMAL)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            viewModel = viewModel,
        )

        PrivateUserTextField(modifier = Modifier.constrainAs(textFields) {
            top.linkTo(personData.bottom, margin = ApplicationUiConst.Padding.BIG)
            start.linkTo(parent.start, margin = ApplicationUiConst.Padding.LARGE)
        }, viewModel.getUser(), viewModel = viewModel)

        Row(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .constrainAs(bottomBar) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = null,
                    modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE),
                    tint = PRIMARY
                ) 
                SmallLightText(text = "Профиль", color = PRIMARY)
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        navController.popBackStack()
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_paper),
                    contentDescription = null,
                    modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE),
                    tint = PRIMARY_70
                )
                SmallLightText(text = "Главня", color = PRIMARY_70)
            }
        }


    }
    
    if (viewModel.openAlertChangeUserPhoto){
        AlertDialog(
            onDismissRequest = { viewModel.openAlertChangeUserPhoto = false },
            buttons = {
                AlertChangeUserImage(navController = navController, viewModel = viewModel, aViewModel = aViewModel)
            },
            modifier = Modifier.clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK)).fillMaxHeight(.6f)
        )
    }

}


@Composable
private fun PrivateUserData(modifier: Modifier, viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(viewModel.getUser() != null){

            MediumLightText(
                text = if(viewModel.getUser().firstName != null && viewModel.getUser().secondName != null)
                    "${viewModel.getUser().secondName} ${viewModel.getUser().firstName}" else "Ты кто дэб?"
            )
            SmallLightText(
                text = if(viewModel.getUser().dateRegister != null)
                    "Дата регистрации ${viewModel.getUser().dateRegister}" else "Дата регистрации ???"
            )
        } else {
            MediumLightText(
                text = "Ты кто дэб?"
            )
            SmallLightText(
                text = "Дата регистрации ???"
            )
        }

    }
}

@Composable
private fun PrivateUserTextField(
    modifier: Modifier,
    userData: UserEntity,
    viewModel: MainViewModel
) {
    var firstName by remember { mutableStateOf(userData.firstName ?: "") }
    var secondName by remember{mutableStateOf(userData.secondName ?: "") }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ApplicationTextField(
            value = firstName,
            placeHolder = "Введи свое имя",
            onValueChange = {
                firstName = it
                coroutineScope.launch {
                    viewModel.updateUserInfo(
                        user = userData.copy(
                            firstName = firstName
                        )
                    )
                }
            },
            icon = R.drawable.ic_pets,
            modifier = Modifier.padding(vertical = ApplicationUiConst.Padding.BIG)
        )
        ApplicationTextField(
            value = secondName,
            placeHolder = "Введи свою фамилию",
            onValueChange = {
                secondName = it
                coroutineScope.launch {
                    viewModel.updateUserInfo(
                        user = userData.copy(
                            secondName = secondName
                        )
                    )
                }
            },
            icon = R.drawable.ic_pets,
            modifier = Modifier.padding(vertical = ApplicationUiConst.Padding.BIG)
        )
    }
}

