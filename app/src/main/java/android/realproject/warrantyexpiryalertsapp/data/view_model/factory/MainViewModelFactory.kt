package android.realproject.warrantyexpiryalertsapp.data.view_model.factory

import android.app.Application
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.navigation.NavController

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val application: Application,
    private val navController: NavController,
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application = application, navController = navController) as T
    }
}