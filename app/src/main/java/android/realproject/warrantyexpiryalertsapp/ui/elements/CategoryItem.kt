package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.model.CategoryItemModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

@Composable
fun CategoryItem(
    categoryItemModel: CategoryItemModel,
    isLastElement: Boolean = false,
    onClickAction: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
                .clickable { onClickAction() }
                .size(ApplicationUiConst.SizeObject.CATEGORY_ITEM)
                .background(if(!isLastElement) SECONDARY else PRIMARY),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = categoryItemModel.image),
                contentDescription = null,
                modifier = Modifier.size(ApplicationUiConst.SizeObject.CATEGORY_ITEM_IMAGE)
            )
        }
        MediumLightText(text = categoryItemModel.title)
    }

}