package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainFragmentHeader(
    modifier: Modifier,
    viewModel: MainViewModel,
    navController: NavController
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(SURFACE)
            .then(modifier)
    ) {
        val (headerContent, bgImage) = createRefs()
        HeaderContent(
            viewModel = viewModel,
            modifier = Modifier
                .padding(horizontal = ApplicationUiConst.Padding.LARGE)
                .constrainAs(headerContent) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = ApplicationUiConst.Padding.BIG)
                },
            navController = navController
        )


    }
}


@Composable
private fun HeaderContent(
    viewModel: MainViewModel,
    modifier: Modifier,
    navController: NavController
) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        UserInfoHeader(
            modifier = Modifier.weight(8f), viewModel = viewModel,
            navController = navController
        )
        Row(
            modifier = Modifier.weight(2f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.CreateProductScreen.route)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription = null,
                    tint = PRIMARY,
                    modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE)
                )
            }

            IconButton(onClick = {
                navController.navigate(Screen.SettingsScreen.route)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = null,
                    tint = PRIMARY,
                    modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE)
                )
            }
        }
    }
}

@Composable
private fun UserInfoHeader(
    modifier: Modifier,
    viewModel: MainViewModel,
    navController: NavController
){
    Row(
        modifier = modifier
            .height(ApplicationUiConst.SizeObject.CATEGORY_ITEM),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AvatarUser(
            viewModel = viewModel,
            modifier = Modifier
                .height(ApplicationUiConst.SizeObject.AVATAR_SIZE)
                .weight(1f)
                .padding(end = ApplicationUiConst.Padding.NORMAL)
                .clickable { navController.navigate(Screen.ProfileUser.route) },

        )
        Column(
            modifier = Modifier.weight(4f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
             MediumBoldText(
                 text = if(
                     viewModel.getUser() != null &&
                     viewModel.getUser().firstName != null &&
                     viewModel.getUser().secondName != null
                 ) "{viewModel.getUser().secondName} {viewModel.getUser().secondName}" else "user"
             )
            SmallLightText(
                text = "Random phrase"
            )
        }
    }
}


@Composable
private fun GetBgDraw(
    modifier: Modifier
) {
    Canvas(
        modifier = Modifier
            .size(200.dp)
            .then(modifier),
        onDraw = {
            val width = size.width
            val height = size.height
            val path = Path().apply {
                moveTo(width.times(.76f), height.times(.72f))
                cubicTo(
                    width.times(.93f),
                    height.times(.72f),
                    width.times(.98f),
                    height.times(.41f),
                    width.times(.76f),
                    height.times(.40f)
                )
                cubicTo(
                    width.times(.75f),
                    height.times(.21f),
                    width.times(.35f),
                    height.times(.21f),
                    width.times(.38f),
                    height.times(.50f)
                )
                cubicTo(
                    width.times(.25f),
                    height.times(.50f),
                    width.times(.20f),
                    height.times(.69f),
                    width.times(.41f),
                    height.times(.72f)
                )
                close()
            }
            drawPath(path = path, color = Color.White.copy(alpha = .90f))
        }
    )
}