package android.realproject.warrantyexpiryalertsapp.splashscreen

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun AnimatedSplashScreen(
    navController: NavController,
    mainViewModel: MainViewModel
){
    var startAnim by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnim) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    val startDestination by remember {
        mutableStateOf(
            if(mainViewModel.getUser() != null) {
                if(mainViewModel.getUser().firstName != null) {
                    Screen.MainScreen.route
                } else {
                    Screen.OnBoarding.route
                }
            } else {
                Screen.OnBoarding.route
            }
        )
    }

    LaunchedEffect(key1 = true ) {
        startAnim = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(startDestination)
    }

    SplashScreenFragment(alphaAnim.value)
}

@Composable
private fun SplashScreenFragment(
    alpha: Float
){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (icon, previewText) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.ap_icon),
            contentDescription = null,
            modifier = Modifier
                .size(65.dp)
                .clip(CircleShape)
                .alpha(alpha)
                .constrainAs(icon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        MediumLightText(
            text = "Добро пожаловать",
            modifier = Modifier.alpha(alpha).constrainAs(previewText){
                top.linkTo(icon.bottom, margin = ApplicationUiConst.Padding.LARGE)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}