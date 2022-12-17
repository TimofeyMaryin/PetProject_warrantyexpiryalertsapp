package android.realproject.warrantyexpiryalertsapp.ui.elements.text

import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.Typography
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun MediumLightText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = PRIMARY,
    maxLine: Int = 1,
    textAlign: TextAlign = TextAlign.Start
) =
    Text(
        text = text,
        style = Typography.caption,
        color = color,
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
        textAlign = textAlign,
        fontWeight = FontWeight.Light
    )


@Composable
fun MediumLightText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = PRIMARY,
    maxLine: Int = 1,
    lineHeight: TextUnit
) =
    Text(
        text = text,
        style = Typography.caption,
        color = color,
        maxLines = maxLine,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
        lineHeight = lineHeight,
        fontWeight = FontWeight.Light
        )