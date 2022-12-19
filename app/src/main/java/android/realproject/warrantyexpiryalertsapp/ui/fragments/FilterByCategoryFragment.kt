package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.ui.elements.UserProductItem
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.LargeBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun FilterByCategoryFragment(
    category: String,
    viewModel: MainViewModel,
    navController: NavController
) {
    val getProductByCategory by remember {
        mutableStateOf(viewModel.getProductByCategory(category))
    }


    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
    ) {
        val (header, cards, hint) = createRefs()


        SmallApplicationHeader(
            titlePreviousFragment = "Категория",
            titleCurrentFragment = category,
            navController = navController,
            onCLick = { navController.navigate(Screen.SettingsScreen.route) },
            iconRes = R.drawable.ic_settings,
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
            }
        )

        if(getProductByCategory.size != 0) {
            LazyColumn(
                modifier = Modifier.constrainAs(cards) {
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            ) {
                items(getProductByCategory.size) {
                    Container {
                        UserProductItem(
                            product = getProductByCategory[it],
                            modifier = Modifier.clickable {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    key = "item",
                                    value = getProductByCategory[it]
                                )
                                navController.navigate(Screen.ShowDetailsScreen.route)
                            }
                        )
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxWidth(.7f)
                    .constrainAs(hint) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LargeBoldText(text = "Упс...")
                SmallLightText(
                    text = "Похоже вы еще не создали ни одного продукта под этой категорией",
                    textAlign = TextAlign.Center
                )
                SmallLightText(
                    text = "Ну ничего не страшно, давай создадим",
                    textAlign = TextAlign.Center
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_circle),
                        contentDescription = null,
                        modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE)
                    )
                }
            }
        }
    }
}