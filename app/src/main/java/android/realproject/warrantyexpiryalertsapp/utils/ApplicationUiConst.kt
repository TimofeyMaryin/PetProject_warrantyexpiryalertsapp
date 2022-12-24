package android.realproject.warrantyexpiryalertsapp.utils

import android.realproject.warrantyexpiryalertsapp.R
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


object ApplicationUiConst {

    object Padding{
        val SMALL = 4.dp
        val NORMAL = 8.dp
        val BIG = 12.dp
        val LARGE = 16.dp
        val VERY_LARGE = 20.dp
        val EXTRA_LARGE = 70.dp
    }

    object Rounded {
        val BLOCK = 40.dp
        val SMALL = 20.dp
        const val CONTENT = 50
        val VERY_SMALL = 8.dp
    }

    object FontSize {
        val SMALL = 14.sp
        val NORMAL = 18.sp
        val LARGE = 22.sp
        val VERY_LARGE = 27.sp
    }

    object FontFamily {
        val jostItalic = FontFamily(Font(R.font.jost_italic_variable_font_wght))
        val jost = FontFamily(Font(R.font.jost_italic_variable_font_wght))
        val rubikSpray = FontFamily(Font(R.font.rubik_spray_paint_regular)) // прикольный мягкий фон
    }


    object SizeObject {
        val AVATAR_SIZE = 150.dp
        val ICON_SIZE = 30.dp
        val CATEGORY_ITEM = 80.dp
        val CATEGORY_ITEM_IMAGE = 50.dp
        val HEIGHT_CARD = 130.dp
        val HEIGHT_HEADER = 80.dp
        val IMAGE_SIZE = 100.dp
        val HEIGHT_ALERT_ELEMENT = 50.dp
        val HEIGHT_DESCRIPTION_ELEMENT = 150.dp
        val HEIGHT_CURRENCY_ELEMENT = 52.dp
        val SIZE_COUNTER = 32.dp
        val HEIGHT_EDIT_TEXT = 50.dp
        val SIZE_ICON_BOARDING = 130.dp
        val HEIGHT_HINT_CARD = 120.dp
    }

    object Gradient {
        val cheapSugar = Brush.verticalGradient(
            0.0f to Color(0xFF5E5368),
            1f to Color.Black
        )
        val maroon = Brush.verticalGradient(
            0.0f to Color(0xFFD58936),
            1f to Color(0xFF69140E)
        )
    }

}