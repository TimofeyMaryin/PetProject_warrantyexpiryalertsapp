package android.realproject.warrantyexpiryalertsapp.ui.elements.text

import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.Typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun MediumLightText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = PRIMARY
) =
    Text(
        text = text,
        style = Typography.caption,
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )