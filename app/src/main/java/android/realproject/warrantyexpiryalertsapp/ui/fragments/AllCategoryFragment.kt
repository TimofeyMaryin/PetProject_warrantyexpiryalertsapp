package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.CategoryItem
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun AllCategoryFragment(
    viewModel: MainViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SmallApplicationHeader(
            titlePreviousFragment = "Категория",
            titleCurrentFragment = "Все",
            onCLickShare = { Toast.makeText(context, "Share button", Toast.LENGTH_SHORT).show() },
            onCLickSetting = { navController.navigate(Screen.SettingsScreen.route) },
            navController = navController
        )

        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(viewModel.allCategoryItem.size) {
                Container {
                    CategoryItem(categoryItemModel = viewModel.allCategoryItem[it]) {
                        viewModel.navigateToCategoryProduct(it, false)
                    }
                }
            }
        }
    }
}