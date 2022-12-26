package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SHADOW_PRODUCT_ITEM
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

@Composable
fun UserProductItem(
    product: ProductsUnderWarrantyEntity,
    modifier: Modifier,
){
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
                .fillMaxWidth()
                .height(ApplicationUiConst.SizeObject.HEIGHT_CARD)
                .then(modifier),
            contentAlignment = Alignment.CenterStart
        ) {
            AsyncImage(
                model = product.imageSrc ,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(modifier = Modifier.fillMaxSize().background(brush = SHADOW_PRODUCT_ITEM))

            MediumBoldText(
                text = product.productName,
                modifier = Modifier.padding(vertical = ApplicationUiConst.Padding.BIG, horizontal = ApplicationUiConst.Padding.SMALL),
                textAlign = TextAlign.Start
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SmallLightText(text = stringResource(id = R.string.warranty_will_disappear))

            val endOfGuarantee by remember {
                mutableStateOf(
                    countMonthToEndGuarantee(product.endOfWarranty)
                )
            }

            SmallLightText(text = "$endOfGuarantee месяцев", fontWeight = FontWeight.Bold, color = SECONDARY)
        }
    }
}

private fun countMonthToEndGuarantee(endOfWarranty: String): String {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy") // способ форматирования строки в дату
    val currentDayEndOfWarranty = LocalDate.parse(formattedText(endOfWarranty), formatter) // отфармотированая дата оканчания даты гарантии

    val currentDate = LocalDate.now()
    val period = Period.of(currentDate.year, currentDate.monthValue, currentDate.dayOfMonth)

    val result = currentDayEndOfWarranty.minus(period).monthValue

    return result.toString()

}

fun formattedText(endOfWarranty: String): String {
    var day = endOfWarranty.substringBefore("/")
    var month = endOfWarranty.substringAfter("/").substringBeforeLast("/")
    val year = endOfWarranty.substringAfterLast("/")

    if(day.length < 2) day = "0$day"
    if(month.length < 2) month = "0$month"

    return "$day/$month/$year"
}
