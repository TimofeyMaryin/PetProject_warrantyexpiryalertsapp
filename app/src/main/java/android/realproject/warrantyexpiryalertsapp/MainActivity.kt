package android.realproject.warrantyexpiryalertsapp

import android.os.Build
import android.os.Bundle
import android.realproject.warrantyexpiryalertsapp.data.navigation.ApplicationNavHost
import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.data.view_model.factory.CreateUserProductViewModelFactory
import android.realproject.warrantyexpiryalertsapp.data.view_model.factory.MainViewModelFactory
import android.realproject.warrantyexpiryalertsapp.login_boarding.AcquaintanceWithApplicationViewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import android.realproject.warrantyexpiryalertsapp.ui.theme.WarrantyExpiryAlertsAppTheme
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
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

                    val createUserProductViewModel: CreateUserProductViewModel by viewModels(
                        factoryProducer = {
                            CreateUserProductViewModelFactory(
                                navController = navController,
                                mainViewModel = mainViewModel
                            )
                        }
                    )
                    val acquaintanceWithApplicationViewModel: AcquaintanceWithApplicationViewModel by viewModels()

                    ApplicationNavHost(
                        navController = navController,
                        mainViewModel = mainViewModel,
                        createUserProductViewModel = createUserProductViewModel,
                        acquaintanceWithApplicationViewModel = acquaintanceWithApplicationViewModel
                    )


                }
            }
        }

        hideSystemUI()
    }

    private fun hideSystemUI() {

        //Hides the ugly action bar at the top
        actionBar?.hide()

        //Hide the status bars

        WindowCompat.setDecorFitsSystemWindows(window, false)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        } else {
            window.insetsController?.apply {
                hide(WindowInsets.Type.statusBars())
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }
}

