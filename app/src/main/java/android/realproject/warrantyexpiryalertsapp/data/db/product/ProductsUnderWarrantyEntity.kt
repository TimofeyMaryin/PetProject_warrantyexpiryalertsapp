package android.realproject.warrantyexpiryalertsapp.data.db.product

import android.os.Parcelable
import android.realproject.warrantyexpiryalertsapp.model.ImageSaveModel
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Currency


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


@Parcelize
@Entity
data class ProductsUnderWarrantyEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo val productName: String,
    @ColumnInfo val imageSrc: String,
    @ColumnInfo val guaranteePeriod: String,
    @ColumnInfo val category: String,
    @ColumnInfo var addiction: String? = null,
    @ColumnInfo val dateOfPurchaseOfTheProduct: String,
    @ColumnInfo val productPrice: String,
    @ColumnInfo val currency: String
): Parcelable


