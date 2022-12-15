package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Container(
    content: @Composable () -> Unit
){
    Box(modifier = Modifier.padding(ApplicationUiConst.Padding.LARGE), contentAlignment = Alignment.Center) {
        content()
    }
}