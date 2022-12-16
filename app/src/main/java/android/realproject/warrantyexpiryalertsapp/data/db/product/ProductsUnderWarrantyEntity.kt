package android.realproject.warrantyexpiryalertsapp.data.db.product

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * ProductsUnderWarrantyEntity()
 *
 * - productName - название товара
 * - imagesProduct - картинка для карточки товара(Any потому что есть вариант в архиве выбрать фото(там ссылочка будет) или же с устройства
 * - endOfWarranty - конец гарантии( те придеться конвертировать Date type в String)
 * - category - ну категория товара, что не понятно то?
 * - addiction - дополнительная информация, которая понадобиться юзеру
 * - dateOfPurchaseOfTheProduct - дата покупки товара
 */


@Entity
data class ProductsUnderWarrantyEntity(
    @PrimaryKey var id: Long = 0,
    @ColumnInfo val productName: String,
    @Embedded val imagesProduct: Any?,
    @ColumnInfo val endOfWarranty: String,
    @ColumnInfo val category: String,
    @ColumnInfo val addiction: String? = null,
    @ColumnInfo val dateOfPurchaseOfTheProduct: String
)
