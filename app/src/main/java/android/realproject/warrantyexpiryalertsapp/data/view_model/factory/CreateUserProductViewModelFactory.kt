package android.realproject.warrantyexpiryalertsapp.data.view_model.factory

import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

@Suppress("UNCHECKED_CAST")
class CreateUserProductViewModelFactory(
    private val navController: NavController,
    private val mainViewModel: MainViewModel
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CreateUserProductViewModel(navController = navController, mainViewModel = mainViewModel) as T
    }
}