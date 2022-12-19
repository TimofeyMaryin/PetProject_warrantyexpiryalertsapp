package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SHADOW_PRODUCT_ITEM
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.realproject.warrantyexpiryalertsapp.utils.IMAGE_ARCHIVE
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage

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
            SmallLightText(text = product.guaranteePeriod, fontWeight = FontWeight.Bold, color = SECONDARY)
        }
    }
}