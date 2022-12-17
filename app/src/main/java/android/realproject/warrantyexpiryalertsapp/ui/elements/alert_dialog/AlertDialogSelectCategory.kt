package android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog

import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
fun AlertDialogSelectCategory(
    viewModel: CreateUserProductViewModel,
    mainViewModel: MainViewModel,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(mainViewModel.allCategoryItem.size){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        viewModel.category = mainViewModel.allCategoryItem[it].title
                        viewModel.openDialogSelectCategory = false
                    }
                    .height(ApplicationUiConst.SizeObject.HEIGHT_ALERT_ELEMENT),
                contentAlignment = Alignment.Center
            ) {
                MediumBoldText(
                    text = "${mainViewModel.allCategoryItem[it].emoji} ${mainViewModel.allCategoryItem[it].title}",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}