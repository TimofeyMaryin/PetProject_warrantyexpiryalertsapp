package android.realproject.warrantyexpiryalertsapp.utils

import android.realproject.warrantyexpiryalertsapp.R
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
    }

    object Rounded {
        val BLOCK = 40.dp
        val SMALL = 20.dp
        const val CONTENT = 50
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
        val AVATAR_SIZE = 130.dp
        val ICON_SIZE = 30.dp
        val CATEGORY_ITEM = 80.dp
        val CATEGORY_ITEM_IMAGE = 50.dp
        val HEIGHT_CARD = 130.dp
        val HEIGHT_HEADER = 80.dp

        const val WIDTH_BLOCK_DEGREE = .95f
    }

}