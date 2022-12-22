package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AcquaintanceWithApplicationFragment(
    viewModel: AcquaintanceWithApplicationViewModel,
    modifier: Modifier,
){

    AnimatedVisibility(
        visible = true,
        enter = fadeIn(initialAlpha = .4f),
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(brush = ApplicationUiConst.Gradient.cheapSugar)
                .then(modifier)
        ) {
            val (titleContain, createdAppText) = createRefs()

            ContainWithLottie(
                modifier = Modifier.constrainAs(titleContain) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = ApplicationUiConst.Padding.VERY_LARGE)
                }.fillMaxHeight(.4f),
                title = "Welcome to my person Application",
                resAnim = R.raw.anim_icon_three,
            )

            SmallLightText(
                text = "Created by Timofey Maryin",
                modifier = Modifier.constrainAs(createdAppText) {
                    top.linkTo(parent.top, margin = ApplicationUiConst.Padding.SMALL)
                    end.linkTo(parent.end, margin = ApplicationUiConst.Padding.BIG)
                },
                color = PRIMARY_70.copy(.5f)
            )


        }

    }

}


