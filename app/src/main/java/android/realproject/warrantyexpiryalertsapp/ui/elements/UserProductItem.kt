package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SHADOW_PRODUCT_ITEM
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
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
import coil.compose.AsyncImage

@Composable
fun UserProductItem(product: ProductsUnderWarrantyEntity){
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
                .fillMaxWidth()
                .height(ApplicationUiConst.SizeObject.HEIGHT_CARD),
            contentAlignment = Alignment.CenterStart
        ) {
            if(product.imagesProduct is String) {
                AsyncImage(
                    model = product.imagesProduct,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    painter = painterResource(id = product.imagesProduct as Int),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(modifier = Modifier.fillMaxSize().background(brush = SHADOW_PRODUCT_ITEM))

            LargeBoldText(text = product.productName)
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SmallLightText(text = stringResource(id = R.string.warranty_will_disappear))
            SmallLightText(text = product.endOfWarranty, fontWeight = FontWeight.Bold, color = SECONDARY)
        }
    }
}