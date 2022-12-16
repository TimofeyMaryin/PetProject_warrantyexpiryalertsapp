package android.realproject.warrantyexpiryalertsapp.data.view_model

import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_GUARANTEE
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_NAME
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_PRICE
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class CreateUserProductViewModel(
    private val navController: NavController,
    private val mainViewModel: MainViewModel
): ViewModel() {
    var productName by mutableStateOf("")
    var dateOfBuyProduct by mutableStateOf("")
    var guaranteePeriod by mutableStateOf("")
    var category by mutableStateOf("")
    var productPrice by mutableStateOf("")
    var currency by mutableStateOf("")
    var description by mutableStateOf("")
    var openDialog by mutableStateOf(false)

    fun changeValue(index: Int, value: String){
        when(index){
            INDEX_PRODUCT_NAME -> productName = value
            INDEX_PRODUCT_PRICE -> productPrice = value
            INDEX_PRODUCT_GUARANTEE -> guaranteePeriod = value
        }
    }

}