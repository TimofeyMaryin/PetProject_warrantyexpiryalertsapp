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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

                val (header, cardHint) = createRefs()

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
                    top.linkTo(header.bottom, margin = (-20).dp)
                }, viewModel = viewModel)

            }

        }

        // category
        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.height(350.dp)
            ) {
                items(viewModel.categoryItemMainFragment.size){
                    val isLastEl = viewModel.categoryItemMainFragment.size == it+1
                    Container {
                        CategoryItem(
                            categoryItemModel = viewModel.categoryItemMainFragment[it],
                            isLastElement = isLastEl,
                            onClickAction = {
                                viewModel.navigateToCategoryProduct(it)
                            },
                            mainViewModel = viewModel
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
            val countAllProduct by remember { mutableStateOf(viewModel.getAllProduct().size) }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = ApplicationUiConst.Padding.LARGE),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // UserProductTextMainFragment()
                MediumLightText(
                    text = "Ваши гарантийные товары ($countAllProduct)",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = ApplicationUiConst.Padding.LARGE),
                )
                for (item in viewModel.getAllProduct()) {
                    Container {
                        UserProductItem(
                            product = item,
                            modifier = Modifier.clickable {
                                navController.currentBackStackEntry?.savedStateHandle?.set(
                                    key = "item",
                                    value = item
                                )
                                navController.navigate(Screen.ShowDetailsScreen.route)
                            }
                        )
                    }
                }
            }
        }

        item { Box(modifier = Modifier.fillMaxWidth().height(250.dp)) }
    }
}


