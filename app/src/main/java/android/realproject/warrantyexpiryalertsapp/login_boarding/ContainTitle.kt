package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun ContainTitle(
    title: String,
    resIcon: Int,
    modifier: Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id =resIcon),
            contentDescription = null,
            modifier = Modifier
                .size(ApplicationUiConst.SizeObject.SIZE_ICON_BOARDING)
                .padding(ApplicationUiConst.Padding.LARGE)
        )
        LargeBoldText(text = title)
    }
}