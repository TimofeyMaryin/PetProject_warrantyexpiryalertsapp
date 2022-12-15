package android.realproject.warrantyexpiryalertsapp

import android.os.Bundle
import android.realproject.warrantyexpiryalertsapp.data.navigation.ApplicationNavHost
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.data.view_model.factory.MainViewModelFactory
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import android.realproject.warrantyexpiryalertsapp.ui.theme.WarrantyExpiryAlertsAppTheme
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController


/**
 * Приложение для отслежживания истечения срока гарантии товара
 */


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WarrantyExpiryAlertsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val navController = rememberNavController()

                    val mainViewModel: MainViewModel by viewModels(
                        factoryProducer = {
                            MainViewModelFactory(application = application, navController = navController)
                        }
                    )

                    ApplicationNavHost(
                        navController = navController,
                        mainViewModel = mainViewModel
                    )


                }
            }
        }
    }
}

