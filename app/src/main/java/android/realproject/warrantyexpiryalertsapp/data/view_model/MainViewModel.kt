package android.realproject.warrantyexpiryalertsapp.data.view_model

import android.app.Application
import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.ApplicationDatabase
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyImpl
import android.realproject.warrantyexpiryalertsapp.data.db.user_info.UserEntity
import android.realproject.warrantyexpiryalertsapp.data.db.user_info.UserImpl
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.model.CategoryItemModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class MainViewModel(
    private val application: Application,
    val navController: NavController
): ViewModel(), UserImpl, ProductsUnderWarrantyImpl {
    private val userDao = ApplicationDatabase.getInstance(application).userDao()
    private val productDao = ApplicationDatabase.getInstance(application).productDao()


    override fun getAllProduct(): MutableList<ProductsUnderWarrantyEntity> = productDao.getAllProduct()
    override suspend fun insertProduct(product: ProductsUnderWarrantyEntity) = productDao.insertProduct(product)
    override suspend fun deleteProduct(product: ProductsUnderWarrantyEntity) = productDao.deleteProduct(product = product)
    override fun getProductByCategory(category: String): MutableList<ProductsUnderWarrantyEntity> = productDao.getProductByCategory(category)
    override suspend fun updateProductElement(product: ProductsUnderWarrantyEntity) = productDao.updateProductElement(product)

    override suspend fun insertUser(user: UserEntity) = userDao.insertUser(user)
    override suspend fun updateUserInfo(user: UserEntity) = userDao.updateUserInfo(user)
    override suspend fun deleteUser(user: UserEntity) = userDao.deleteUser(user)
    override fun getUser(): UserEntity = userDao.getUser()


    val categoryItemMainFragment = listOf(
        CategoryItemModel(R.drawable.motherboard, "Микроэлектроника", "Микроэлектроника", "\uD83D\uDCF1"),
        CategoryItemModel(R.drawable.car, "Авто", "Авто", "\uD83D\uDE97 "),
        CategoryItemModel(R.drawable.furnitureandhousehold, "Бытовая теххника", "Бытовая теххника", "\uD83D\uDECB️"),
        CategoryItemModel(R.drawable.cash, "Бизнес", "Бизнес", "\uD83D\uDCB8"),
        CategoryItemModel(R.drawable.baby, "Для детей", "Для детей", "\uD83E\uDDD2\uD83C\uDFFF"),
        CategoryItemModel(R.drawable.more, "Прочее", "other", "")
    )

    val allCategoryItem = listOf(
        CategoryItemModel(R.drawable.motherboard, "Микроэлектроника", "Микроэлектроника", "\uD83D\uDCF1"),
        CategoryItemModel(R.drawable.car, "Авто", "Авто", "\uD83D\uDE97 "),
        CategoryItemModel(R.drawable.furnitureandhousehold, "Бытовая теххника", "Бытовая теххника", "\uD83D\uDECB️"),
        CategoryItemModel(R.drawable.cash, "Бизнес", "Бизнес", "\uD83D\uDCB8"),
        CategoryItemModel(R.drawable.baby, "Для детей", "Для детей", "\uD83E\uDDD2\uD83C\uDFFF"),
        CategoryItemModel(R.drawable.motherboard, "Микроэлектроника", "Микроэлектроника", "\uD83D\uDCF1"),
        CategoryItemModel(R.drawable.car, "Авто", "Авто", "\uD83D\uDE97 "),
        CategoryItemModel(R.drawable.furnitureandhousehold, "Бытовая теххника", "Бытовая теххника", "\uD83D\uDECB️"),
        CategoryItemModel(R.drawable.cash, "Бизнес", "Бизнес", "\uD83D\uDCB8"),
        CategoryItemModel(R.drawable.baby, "Для детей", "Для детей", "\uD83E\uDDD2\uD83C\uDFFF"),
    )

    fun navigateToCategoryProduct(index: Int, needLastEl: Boolean = true){
        val isLastEl = categoryItemMainFragment.size == (index+1)

        if(!needLastEl) {
            navController.navigate("${Screen.CategoryProductScreen.route}/${allCategoryItem[index].category}")
            return
        }

        if(isLastEl){
            navController.navigate(Screen.AllCategoryScreen.route)

        } else {
            navController.navigate("${Screen.CategoryProductScreen.route}/${categoryItemMainFragment[index].category}")
        }
    }

    fun checkTimeOutWarranty(dateOfBuyProduct: String, guaranteePeriod: String): String{
        return "00/00/2000"
    }
    fun navigateWithArgument(route: String, argument: String){
        navController.navigate("$route/$argument")
    }

    fun popBackStack() = navController.popBackStack()


    fun formatterPrice(price: String): String {
        var result = ""
        val revPrice = price.reversed()
        for (i in revPrice.indices) {
            if(i % 3 == 0 && i > 2){
                result += " "
            }
            result += revPrice[i].toString()
        }

        return result.reversed()
    }


    var openAlertEditDesc by mutableStateOf(false)

    fun setHeightAlert(text: String): Float {
        return when (text.length) {
            in 0 until 20 -> .6f
            in 20 until 40 -> .75f
            in 40 until 60 -> .9f
            else -> 1f

        }
    }
}