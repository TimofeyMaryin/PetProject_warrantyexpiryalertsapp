package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.*
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.AdditionallyInfoText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.UserProductTextMainFragment
import android.realproject.warrantyexpiryalertsapp.ui.theme.BACKGROUND
import android.realproject.warrantyexpiryalertsapp.utils.ADDITIONALLY_APPLICATION_ITEM
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainFragment(
    viewModel: MainViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        // header
        item {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BACKGROUND)
            ) {

                val (header, cardHint, categoryElement, addictionInfoElement, userProduct) = createRefs()

                MainFragmentHeader(
                    modifier = Modifier.constrainAs(header) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    viewModel = viewModel,
                    navController = navController
                )

                CardHintElement(modifier = Modifier.constrainAs(cardHint) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(header.bottom, margin = (-50).dp)
                })

            }

        }

        // category
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.height(270.dp)
            ) {
                items(viewModel.categoryItemMainFragment.size){
                    val isLastEl = viewModel.categoryItemMainFragment.size == it+1
                    Container {
                        CategoryItem(
                            viewModel.categoryItemMainFragment[it],
                            isLastElement = isLastEl,
                            onClickAction = {
                                viewModel.navigateToCategoryProduct(it)
                            }
                        )
                    }
                }
            }
        }

        // additionally info
        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = ApplicationUiConst.Padding.LARGE),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // AdditionallyInfoText()
                MediumLightText(
                    text = "Дополнительная информация",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = ApplicationUiConst.Padding.LARGE)
                )
                for (item in ADDITIONALLY_APPLICATION_ITEM.indices) {
                    Container {
                        AdditionallyItem(additionallyApplicationModel = ADDITIONALLY_APPLICATION_ITEM[item]) {
                            Log.e("MainFragment", "index: $item", )
                            navController.navigate("${Screen.AdditionallyScreen.route}/$item")
                        }
                    }
                }
            }

        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = ApplicationUiConst.Padding.LARGE),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // UserProductTextMainFragment()
                MediumLightText(
                    text = "Ваши гарантийные товары",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = ApplicationUiConst.Padding.LARGE),
                )
                for (item in viewModel.getAllProduct()) {
                    Container {
                        UserProductItem(product = item, modifier = Modifier.clickable{navController.navigate(Screen.ShowDetailsScreen.route)})
                    }
                }
            }
        }

        item { Box(modifier = Modifier.fillMaxWidth().height(250.dp)) }
    }
}


