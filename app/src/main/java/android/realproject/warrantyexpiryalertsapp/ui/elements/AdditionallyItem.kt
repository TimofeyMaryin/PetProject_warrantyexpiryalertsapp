package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.model.AdditionallyApplicationModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdditionallyItem(
    additionallyApplicationModel: AdditionallyApplicationModel,
    transition: () -> Unit
) {

    ConstraintLayout(
        modifier = Modifier
            .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
            .fillMaxWidth(.85f)
            .height(130.dp)
            .background(SURFACE)
            .clickable { transition() }
    ) {
        val (_title, _timeToRead, _action) = createRefs()

        MediumLightText(
            text = stringResource(id = additionallyApplicationModel.title),
            modifier = Modifier
                .fillMaxWidth(.5f)
                .constrainAs(_title) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start, margin = ApplicationUiConst.Padding.LARGE)
                },
            maxLine = 2,
            lineHeight = 20.sp
        )

        SmallLightText(text = "${additionallyApplicationModel.timeToRead} минут", modifier = Modifier.constrainAs(_timeToRead) {
            bottom.linkTo(parent.bottom, margin = ApplicationUiConst.Padding.BIG)
            start.linkTo(parent.start, margin = ApplicationUiConst.Padding.LARGE)
        })

        SmallLightText(
            text = "Читать ->",
            color = SECONDARY,
            modifier = Modifier.constrainAs(_action) {
                bottom.linkTo(parent.bottom, margin = ApplicationUiConst.Padding.BIG)
                end.linkTo(parent.end, margin = ApplicationUiConst.Padding.LARGE)
            },
        )
    }

}