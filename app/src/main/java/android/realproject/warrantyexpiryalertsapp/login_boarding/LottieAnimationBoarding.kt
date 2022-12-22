package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.airbnb.lottie.compose.*
import okhttp3.Route

@Composable
fun LottieAnimationBoarding(
    hintModel: HintModel
){
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(hintModel.resAnim)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember { mutableStateOf(1f) }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations =  LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = ApplicationUiConst.Padding.BIG),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK))
                .background(Color.Gray.copy(.4f)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MediumBoldText(text = hintModel.title)
            LottieAnimation(
                composition = composition,
                progress = progress,
                modifier = Modifier.size(ApplicationUiConst.SizeObject.IMAGE_SIZE)
            )
        }
    }

}


@Composable
fun OnlyLottieAnimation(
    resAnim: Int,
    modifier: Modifier,
){
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(resAnim)
    )
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember { mutableStateOf(1f) }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations =  LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false
    )


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = ApplicationUiConst.Padding.BIG)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(composition = composition, progress = progress)
    }

}