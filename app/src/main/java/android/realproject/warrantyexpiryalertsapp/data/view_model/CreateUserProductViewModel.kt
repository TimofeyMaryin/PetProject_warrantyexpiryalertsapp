package android.realproject.warrantyexpiryalertsapp.data.view_model

import android.graphics.Bitmap
import android.net.Uri
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.model.ImageSaveModel
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_GUARANTEE
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_NAME
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_PRICE
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

class CreateUserProductViewModel(
    private val navController: NavController,
    private val mainViewModel: MainViewModel
): ViewModel() {
    var productName by mutableStateOf("")
    var dateOfBuyProduct by mutableStateOf("")
    var guaranteePeriod by mutableStateOf("")
    var category by mutableStateOf("")
    var productPrice by mutableStateOf("")
    var currency by mutableStateOf("$")
    var description by mutableStateOf("")
    var imageModel by mutableStateOf<String?>(null)

    var selectedImageUri by mutableStateOf<Uri?>(null)

    var openDialogSelectImage by mutableStateOf(false)
    var openDialogSelectCurrency by mutableStateOf(false)
    var openDialogSelectCategory by mutableStateOf(false)


    fun changeValue(index: Int, value: String){
        when(index){
            INDEX_PRODUCT_NAME -> productName = value
            INDEX_PRODUCT_PRICE -> productPrice = value
            INDEX_PRODUCT_GUARANTEE -> guaranteePeriod = value
        }
    }


    // TODO("РЕАЛИЗОВАТЬ И НЕ ЗАБЫТЬ!!")
    fun validateCurrentEnterData() {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")



        val userEnterDate = LocalDate.parse(dateOfBuyProduct)
    }

    suspend fun createCard() {
        mainViewModel.insertProduct(
            ProductsUnderWarrantyEntity(
                category = category,
                guaranteePeriod = guaranteePeriod,
                addiction = description,
                dateOfPurchaseOfTheProduct = dateOfBuyProduct,
                imageSrc = imageModel!!,
                productName = productName,
                productPrice = productPrice,
                currency = currency
            )
        )
    }

}