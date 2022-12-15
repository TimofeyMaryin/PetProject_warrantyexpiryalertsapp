package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.app.Application
import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.ApplicationTextField
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.BACKGROUND
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.service.autofill.UserData
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileUserFragment(
    viewModel: MainViewModel,
    navController: NavController
){

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (
            cardImage, avatar,
            personData, exitButton,
            textFields
        ) = createRefs()


        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(ApplicationUiConst.SizeObject.ICON_SIZE)
                    .constrainAs(exitButton) {
                        top.linkTo(parent.top,)
                        start.linkTo(parent.start,)
                    }
            )
        }

        if(
            viewModel.getUser() != null &&
            viewModel.getUser().avatar != null
        ) {
            Image(
                bitmap = viewModel.getUser().avatar!!.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(cardImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )
            Image(
                bitmap = viewModel.getUser().avatar!!.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(BorderStroke(3.dp, BACKGROUND), CircleShape)
                    .size(ApplicationUiConst.SizeObject.AVATAR_SIZE)
                    .constrainAs(avatar) {
                        top.linkTo(cardImage.bottom, margin = (-65).dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
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

            Image(
                painter = painterResource(id = R.drawable.default_avatar),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(BorderStroke(3.dp, BACKGROUND), CircleShape)
                    .size(ApplicationUiConst.SizeObject.AVATAR_SIZE)
                    .constrainAs(avatar) {
                        top.linkTo(cardImage.bottom, margin = (-65).dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
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
        })


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
    modifier: Modifier
) {
    var firstName by remember { mutableStateOf("") }
    var secondName by remember{mutableStateOf("") }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ApplicationTextField(
            value = firstName,
            placeHolder = "Введи свое имя",
            onValueChange = { firstName = it },
            icon = R.drawable.ic_pets,
            modifier = Modifier.padding(vertical = ApplicationUiConst.Padding.BIG)
        )
        ApplicationTextField(
            value = secondName,
            placeHolder = "Введи свою фамилию",
            onValueChange = { secondName = it },
            icon = R.drawable.ic_pets,
            modifier = Modifier.padding(vertical = ApplicationUiConst.Padding.BIG)
        )
    }
}