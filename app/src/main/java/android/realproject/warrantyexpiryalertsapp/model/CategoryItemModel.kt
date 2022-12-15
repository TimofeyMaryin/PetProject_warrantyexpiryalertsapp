package android.realproject.warrantyexpiryalertsapp.model


/**
 * image - просто картинка для карточки
 * title - название карточки
 * category - уже категория, которая будет использоввана онли разработчиков
 */

data class CategoryItemModel(
    val image: Int,
    val title: String,
    val category: String
)
