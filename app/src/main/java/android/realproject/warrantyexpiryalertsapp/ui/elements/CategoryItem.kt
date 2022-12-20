package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.model.CategoryItemModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.ORANGE
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage

@Composable
fun CategoryItem(
    categoryItemModel: CategoryItemModel,
    isLastElement: Boolean = false,
    mainViewModel: MainViewModel,
    onClickAction: () -> Unit,
) {
    val countItem by remember { mutableStateOf(mainViewModel.getProductByCategory(category = categoryItemModel.title).size) }
    ConstraintLayout(
        modifier = Modifier.clickable { onClickAction() }
    ) {
        val (content, counter) = createRefs()


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.constrainAs(content){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
                    .size(ApplicationUiConst.SizeObject.CATEGORY_ITEM)
                    .background(if (!isLastElement) SECONDARY else PRIMARY),
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
        if(!isLastElement && countItem != 0) {
            Box(
                modifier = Modifier
                    .size(ApplicationUiConst.SizeObject.SIZE_COUNTER)
                    .clip(CircleShape)
                    .background(ORANGE)
                    .constrainAs(counter) {
                        top.linkTo(parent.top, margin = -(ApplicationUiConst.Padding.SMALL))
                        end.linkTo(parent.end, margin = -(ApplicationUiConst.Padding.SMALL))
                    },
                contentAlignment = Alignment.Center
            ) {
                SmallLightText(text = countItem.toString())
            }

        }

    }

}