package android.realproject.warrantyexpiryalertsapp.ui.elements.text

import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdditionallyInfoText(){
    Row(
        modifier = Modifier
            .fillMaxWidth(.9f),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MediumLightText(text = "Дополнительная информация", modifier = Modifier.weight(8f))
        Box(modifier = Modifier.height(1.dp).background(PRIMARY).weight(3f))
    }
}