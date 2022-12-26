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
import java.time.Period
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


    var openDialogSelectCurrency by mutableStateOf(false)
    var openDialogSelectCategory by mutableStateOf(false)


    fun changeValue(index: Int, value: String){
        when(index){
            INDEX_PRODUCT_NAME -> if(value.length <= 34) productName = value
            INDEX_PRODUCT_PRICE -> productPrice = value
            INDEX_PRODUCT_GUARANTEE -> guaranteePeriod = value
        }
    }

    fun setDateEndOfWarranty(): String{
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val _dateOfBuyProduct = LocalDate.parse(dateOfBuyProduct, formatter)
        val period = Period.of(0, guaranteePeriod.toInt(), 0)
        val dateWithPeriod = _dateOfBuyProduct.plus(period)

        val monthValue = if(dateWithPeriod.month.toString().length < 2) "0${dateWithPeriod.monthValue}" else dateWithPeriod.monthValue
        val dayValue = if(dateWithPeriod.dayOfMonth.toString().length < 2) "0${dateWithPeriod.dayOfMonth}" else dateWithPeriod.dayOfMonth

        return "${dayValue}/${monthValue}/${dateWithPeriod.year}"
    }

    fun validateCurrentEnterData(
        year: Int, month: Int, dayOfMonth: Int
    ): Boolean {
        val dateOfUser = LocalDate.of(year, month, dayOfMonth)
        val currentDate = LocalDate.now()

        return dateOfUser <= currentDate
    }

    suspend fun createCard() {
        mainViewModel.insertProduct(
            ProductsUnderWarrantyEntity(
                category = category,
                guaranteePeriod = guaranteePeriod,
                addiction = description,
                dateOfPurchaseOfTheProduct = dateOfBuyProduct,
                imageSrc = imageModel,
                productName = productName,
                productPrice = productPrice,
                currency = currency,
                endOfWarranty = setDateEndOfWarranty()
            )
        )
    }

    fun clear(){
        productName = ""
        dateOfBuyProduct = ""
        category = ""
        guaranteePeriod = ""
        productPrice = ""
        imageModel = ""
        description = ""
    }

}