package android.realproject.warrantyexpiryalertsapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = PRIMARY,
    primaryVariant = PRIMARY,
    secondary = SECONDARY,
    background = BACKGROUND,
    surface = SURFACE
)



@Composable
fun WarrantyExpiryAlertsAppTheme(
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val colors = DarkColorPalette


    systemUiController.isStatusBarVisible = false
    systemUiController.setStatusBarColor(color = Color.Transparent)

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}