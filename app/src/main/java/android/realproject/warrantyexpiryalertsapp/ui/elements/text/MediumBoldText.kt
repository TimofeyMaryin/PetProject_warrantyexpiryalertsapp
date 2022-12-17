package android.realproject.warrantyexpiryalertsapp.ui.elements.text

import android.realproject.warrantyexpiryalertsapp.ui.theme.Typography
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MediumBoldText(
    text: String,
) =
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        style = Typography.caption,
    )


@Composable
fun MediumBoldText(
    text: String,
    modifier: Modifier,
    textAlign: TextAlign
) =
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        style = Typography.caption,
        modifier = modifier,
        textAlign = textAlign
    )