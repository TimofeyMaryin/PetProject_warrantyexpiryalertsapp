package android.realproject.warrantyexpiryalertsapp.model


/**
 * Простая моделька, но все же надо уточнить.
 * timeToRead - время чтения, указываеться простое число минут.
 * mainContent - основной текст карточки(будет находиться в string ресурсе.
 * images - список картинок, которые будут находиться в фрагменте
 */

data class AdditionallyApplicationModel(
    val title: Int,
    val timeToRead: Int,
    val mainContent: Int,
    val images: List<String>?,
)
