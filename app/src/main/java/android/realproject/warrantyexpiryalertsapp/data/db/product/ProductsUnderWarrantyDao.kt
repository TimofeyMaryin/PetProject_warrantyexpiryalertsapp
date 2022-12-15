package android.realproject.warrantyexpiryalertsapp.data.db.product

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ProductsUnderWarrantyDao {

    @Insert
    suspend fun insertProduct(product: ProductsUnderWarrantyEntity)

    @Delete
    suspend fun deleteProduct(product: ProductsUnderWarrantyEntity)

    @Query("select * from productsunderwarrantyentity")
    fun getAllProduct(): MutableList<ProductsUnderWarrantyEntity>

    @Query("select * from productsunderwarrantyentity where category = :category")
    suspend fun getProductByCategory(category: String): MutableList<ProductsUnderWarrantyEntity>

}