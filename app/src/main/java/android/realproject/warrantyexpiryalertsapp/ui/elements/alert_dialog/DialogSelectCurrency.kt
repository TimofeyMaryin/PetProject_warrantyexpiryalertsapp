package android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog

import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.realproject.warrantyexpiryalertsapp.utils.CURRENCY_ITEMS
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DialogSelectCurrency(
    viewModel: CreateUserProductViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center
    ) {
        items(CURRENCY_ITEMS.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(ApplicationUiConst.Padding.BIG)
                    .clickable {
                        viewModel.currency = CURRENCY_ITEMS[index].icon
                        viewModel.openDialogSelectCurrency = false
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                MediumBoldText(text = "${CURRENCY_ITEMS[index].title} (${CURRENCY_ITEMS[index].icon})")
            }
        }
    }
}