package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ContainWithLottie(
    modifier: Modifier,
    title: String,
    resAnim: Int,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OnlyLottieAnimation(resAnim = resAnim, modifier = Modifier.weight(1f))
        MediumBoldText(
            text = title,
            modifier = Modifier.weight(1f)
        )
    }
}
