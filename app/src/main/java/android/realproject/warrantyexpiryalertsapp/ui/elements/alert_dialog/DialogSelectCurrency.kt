package android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog

import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.realproject.warrantyexpiryalertsapp.utils.CURRENCY_ITEMS
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun DialogSelectCurrency(
    viewModel: CreateUserProductViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center,

    ) {
        items(CURRENCY_ITEMS.size) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(ApplicationUiConst.SizeObject.HEIGHT_CURRENCY_ELEMENT)
                    .clickable {
                        viewModel.currency = CURRENCY_ITEMS[index].icon
                        viewModel.openDialogSelectCurrency = false
                    },
                contentAlignment = Alignment.Center){
                Row(
                    modifier = Modifier.fillMaxWidth(.8f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(ApplicationUiConst.SizeObject.ICON_SIZE)
                            .clip(
                                CircleShape,
                            ),
                        contentAlignment = Alignment.Center,
                    ){
                        Image(
                            painter = painterResource(id = CURRENCY_ITEMS[index].imageCountryFlag),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    MediumBoldText(text = "${CURRENCY_ITEMS[index].title} ", textAlign = TextAlign.End, modifier = Modifier)
                }
            }
        }
    }
}