package android.realproject.warrantyexpiryalertsapp.data.navigation

import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.animation.TransitionUnderFragment
import android.realproject.warrantyexpiryalertsapp.ui.fragments.*
import android.realproject.warrantyexpiryalertsapp.utils.ADDITIONALLY_APPLICATION_ITEM
import android.realproject.warrantyexpiryalertsapp.utils.PRODUCT_ITEM_ARGUMENT
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ApplicationNavHost(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    createUserProductViewModel: CreateUserProductViewModel
) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        // Фрагменты не нуждающиеся в дип линках
        composable(Screen.MainScreen.route){

            MainFragment(mainViewModel, navController = navController)
        }

        composable(Screen.AllCategoryScreen.route){
            TransitionUnderFragment {
                AllCategoryFragment(mainViewModel, navController = navController)
            }
        }

        composable(Screen.CreateProductScreen.route) {
            TransitionUnderFragment {
                CreateProductFragment(
                    navController = navController,
                    viewModel = createUserProductViewModel
                )
            }
        }

        composable(Screen.SettingsScreen.route) {
            TransitionUnderFragment {
                SettingsFragment()
            }
        }

        composable(Screen.ProfileUser.route) {
            TransitionUnderFragment {
                ProfileUserFragment(navController = navController, viewModel = mainViewModel)
            }
        }

        // Фрагменты, нуждающиеся в дип линках(аргументах)

        composable("${Screen.CategoryProductScreen.route}/{category}") {
            val category = it.arguments?.getString("category", "b")

            TransitionUnderFragment {
                FilterByCategoryFragment(
                    category = category!!,
                    viewModel = mainViewModel,
                    navController = navController
                )
            }
        }

        composable("${Screen.ProductItemScreen.route}/{$PRODUCT_ITEM_ARGUMENT}") {

            val argument = it.arguments?.getInt(PRODUCT_ITEM_ARGUMENT, 0)
            TransitionUnderFragment {
                ProductItemFragment()
            }
        }

        composable("${Screen.AdditionallyScreen.route}/{item}") {

            val argument = it.arguments?.getString("item", "1")
            TransitionUnderFragment {
                AdditionallyFragment(index = argument!!.toInt())
            }
        }

    }
}