package android.realproject.warrantyexpiryalertsapp.ui.elements.text

import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.Typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun LargeBoldText(
    text: String,
    maxLines: Int,
    modifier: Modifier = Modifier,
    color: Color = PRIMARY
) = Text(
    text = text,
    maxLines = maxLines,
    overflow = TextOverflow.Ellipsis,
    fontWeight = FontWeight.Bold,
    style = Typography.h3,
    modifier = modifier,
    color = color,
)

@Composable
fun LargeBoldText(
    text: String,
    modifier: Modifier = Modifier,
) = Text(
    text = text,
    overflow = TextOverflow.Ellipsis,
    fontWeight = FontWeight.Bold,
    modifier = modifier,
    color = SECONDARY,
    fontSize = 48.sp,
    textAlign = TextAlign.Center
)