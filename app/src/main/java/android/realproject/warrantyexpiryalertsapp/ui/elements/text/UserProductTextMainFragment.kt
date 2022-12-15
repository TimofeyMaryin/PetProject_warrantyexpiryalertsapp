package android.realproject.warrantyexpiryalertsapp.ui.elements.text

import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserProductTextMainFragment() {
    Row(
        modifier = Modifier
            .fillMaxWidth(.9f),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MediumLightText(text = "Ваши гарантийные товары", modifier = Modifier.weight(8f))
        Box(modifier = Modifier.height(1.dp).background(PRIMARY).weight(3f))
    }
}