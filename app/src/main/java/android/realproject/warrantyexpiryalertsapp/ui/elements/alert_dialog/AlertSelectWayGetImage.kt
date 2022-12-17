package android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog

import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.coroutineScope

@Composable
fun AlertSelectWayGetImage(
    fromArchive: () -> Unit,
    fromGallery: () -> Unit,
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Container {
            MediumLightText(
                text = "Из архива",
                modifier = Modifier
                    .clickable { fromArchive() }
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Container {
            MediumLightText(
                text = "Из галерии",
                modifier = Modifier
                    .clickable { fromGallery() }
                    .fillMaxWidth(),
                textAlign = TextAlign.Center

            )
        }
    }
}