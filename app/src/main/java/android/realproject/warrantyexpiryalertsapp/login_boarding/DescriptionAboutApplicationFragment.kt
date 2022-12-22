package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun DescriptionAboutApplicationFragment(
    viewModel: AcquaintanceWithApplicationViewModel,
    modifier: Modifier,
) {
    ConstraintLayout(
        modifier = Modifier.background(ApplicationUiConst.Gradient.maroon).then(modifier)
    ) {
        val (contain, content, createdAppText) = createRefs()


        ContainWithLottie(
            title = "Now you can study use application",
            resAnim = R.raw.anim_icon_two,
            modifier = Modifier.constrainAs(contain) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(content.top, margin = ApplicationUiConst.Padding.LARGE)
            }.fillMaxHeight(.4f))

        SmallLightText(
            text = "Created by Timofey Maryin",
            modifier = Modifier.constrainAs(createdAppText) {
                top.linkTo(parent.top, margin = ApplicationUiConst.Padding.SMALL)
                end.linkTo(parent.end, margin = ApplicationUiConst.Padding.BIG)
            },
            color = PRIMARY_70.copy(.5f)
        )

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.6f)
            .constrainAs(content) {
                top.linkTo(contain.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(viewModel.hintList.size) {
                LottieAnimationBoarding(hintModel = viewModel.hintList[it])
            }
        }
    }
}