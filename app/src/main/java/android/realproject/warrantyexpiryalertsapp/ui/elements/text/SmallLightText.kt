package android.realproject.warrantyexpiryalertsapp.ui.elements.text

import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.Typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SmallLightText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Light,
    color: Color = PRIMARY,
    textAlign: TextAlign = TextAlign.Start
) = Text(
    text = text,
    style = Typography.subtitle2,
    modifier = modifier,
    fontWeight = fontWeight,
    color = color,
    textAlign = textAlign
)