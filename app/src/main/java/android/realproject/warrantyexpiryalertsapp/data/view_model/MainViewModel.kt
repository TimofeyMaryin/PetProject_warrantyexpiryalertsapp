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
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class MainViewModel(
    private val application: Application,
    private val navController: NavController
): ViewModel(), UserImpl, ProductsUnderWarrantyImpl {
    private val userDao = ApplicationDatabase.getInstance(application).userDao()
    private val productDao = ApplicationDatabase.getInstance(application).productDao()


    override fun getAllProduct(): MutableList<ProductsUnderWarrantyEntity> = productDao.getAllProduct()
    override suspend fun insertProduct(product: ProductsUnderWarrantyEntity) = productDao.insertProduct(product)
    override suspend fun deleteProduct(product: ProductsUnderWarrantyEntity) = productDao.deleteProduct(product = product)
    override suspend fun getProductByCategory(category: String): MutableList<ProductsUnderWarrantyEntity> = productDao.getProductByCategory(category)

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


}