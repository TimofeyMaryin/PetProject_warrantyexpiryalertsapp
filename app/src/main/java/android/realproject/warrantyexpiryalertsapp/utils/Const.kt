package android.realproject.warrantyexpiryalertsapp.utils

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.model.AdditionallyApplicationModel
import android.realproject.warrantyexpiryalertsapp.model.CurrencyModel

const val PRODUCT_ITEM_ARGUMENT = "count_item"
const val INDEX_PRODUCT_NAME = 0
const val INDEX_PRODUCT_PRICE = 1
const val INDEX_PRODUCT_GUARANTEE = 2


val ADDITIONALLY_APPLICATION_ITEM = listOf(
    AdditionallyApplicationModel(R.string.hint_title_1, 5, R.string.hint_content_1, null),
    AdditionallyApplicationModel(R.string.hint_title_2, 10, R.string.hint_content_2, null),
    AdditionallyApplicationModel(R.string.hint_title_3, 8, R.string.hint_content_3, null),
    AdditionallyApplicationModel(R.string.hint_title_4, 17, R.string.hint_content_4, null),
    AdditionallyApplicationModel(R.string.hint_title_5, 10, R.string.hint_content_5, null)
)

val CURRENCY_ITEMS = listOf(
    CurrencyModel("$", "Доллар"),
    CurrencyModel("₽", "Рубль"),
    CurrencyModel("€", "Евро"),
    CurrencyModel("¥", "Юань"),
    CurrencyModel("₤", "Фунт"),
)


val IMAGE_ARCHIVE = listOf(
    "https://i.pinimg.com/236x/22/6d/f2/226df2d88df0b8571244a4a289698ace.jpg",
    "https://i.pinimg.com/236x/60/df/f4/60dff4f321506af6452c225f9bb31dba.jpg",
    "https://i.pinimg.com/236x/c8/a8/80/c8a880cc116461f60966cc7f574b4431.jpg",
    "https://i.pinimg.com/236x/b2/6c/7d/b26c7d5e9dc46316630ef071391a84fc.jpg",
    "https://i.pinimg.com/236x/8d/dc/7a/8ddc7a9814744bd6c3f34c45025ff9e3.jpg",
    "https://i.pinimg.com/236x/9b/ba/cc/9bbacc529003a8397914f5c13103e340.jpg",
    "https://i.pinimg.com/236x/d1/32/fa/d132fae1981436d549cebf29d2b1ee98.jpg",
    "https://i.pinimg.com/236x/8e/36/18/8e36181070c3dff668b24fddd624cf78.jpg",
    "https://i.pinimg.com/236x/c8/a8/80/c8a880cc116461f60966cc7f574b4431.jpg",
    "https://i.pinimg.com/236x/b2/6c/7d/b26c7d5e9dc46316630ef071391a84fc.jpg",
    "https://i.pinimg.com/236x/8d/dc/7a/8ddc7a9814744bd6c3f34c45025ff9e3.jpg",
    "https://i.pinimg.com/236x/9b/ba/cc/9bbacc529003a8397914f5c13103e340.jpg",
    "https://i.pinimg.com/236x/d1/32/fa/d132fae1981436d549cebf29d2b1ee98.jpg",
    "https://i.pinimg.com/236x/8e/36/18/8e36181070c3dff668b24fddd624cf78.jpg",
    "https://i.pinimg.com/236x/e8/49/b8/e849b8c7d4f36244fca006d589013c09.jpg",
    "https://i.pinimg.com/236x/2c/74/e4/2c74e491d30ee58c642ff24ad37a0726.jpg",
    "https://i.pinimg.com/236x/2e/94/31/2e9431e9307d0715823e6a4b65998b9e.jpg",
    "https://i.pinimg.com/236x/2c/74/e4/2c74e491d30ee58c642ff24ad37a0726.jpg",
    "https://i.pinimg.com/236x/ae/f8/b9/aef8b9fd05fcfcbaaa1bd852196c6ce2.jpg",
    "https://i.pinimg.com/236x/4a/2c/db/4a2cdbaa8bf25152d4d5b047fddb83b4.jpg",
    "https://i.pinimg.com/236x/79/7a/4e/797a4e4523a1ab1190729df6bd94dc13.jpg",
    "https://i.pinimg.com/236x/bd/a0/72/bda0720fd4be874b731cd967d813c9be.jpg",
    "https://i.pinimg.com/236x/ec/22/48/ec2248092ecc01851b3481395564c68f.jpg",
    "https://i.pinimg.com/236x/ea/2f/0c/ea2f0c7a70cdadaa12eb6a7ab2647906.jpg",
    "https://i.pinimg.com/564x/e6/68/8f/e6688f4eaec9de6db74b9dd19b8b3745.jpg",
    "https://i.pinimg.com/236x/59/1d/a6/591da6d4176c1639176245e3256289c0.jpg",
    "https://i.pinimg.com/236x/c3/be/fc/c3befc7e936594ed41ae680367e3d097.jpg",
    "https://i.pinimg.com/236x/3c/c6/d8/3cc6d8dc97b64df42a3108c48d6304eb.jpg"
)

//val CAR_IMAGE_ARCHIVE = listOf(
//    "https://i.pinimg.com/236x/e8/49/b8/e849b8c7d4f36244fca006d589013c09.jpg",
//    "https://i.pinimg.com/236x/2c/74/e4/2c74e491d30ee58c642ff24ad37a0726.jpg",
//    "https://i.pinimg.com/236x/2e/94/31/2e9431e9307d0715823e6a4b65998b9e.jpg",
//    "https://i.pinimg.com/236x/2c/74/e4/2c74e491d30ee58c642ff24ad37a0726.jpg",
//    "https://i.pinimg.com/236x/ae/f8/b9/aef8b9fd05fcfcbaaa1bd852196c6ce2.jpg",
//    "https://i.pinimg.com/236x/4a/2c/db/4a2cdbaa8bf25152d4d5b047fddb83b4.jpg",
//    "https://i.pinimg.com/236x/79/7a/4e/797a4e4523a1ab1190729df6bd94dc13.jpg",
//    "https://i.pinimg.com/236x/bd/a0/72/bda0720fd4be874b731cd967d813c9be.jpg",
//    "https://i.pinimg.com/236x/ec/22/48/ec2248092ecc01851b3481395564c68f.jpg",
//    "https://i.pinimg.com/236x/ea/2f/0c/ea2f0c7a70cdadaa12eb6a7ab2647906.jpg",
//)
//
//val BUSINESS_IMAGE_ARCHIVE = listOf(
//    "https://i.pinimg.com/564x/e6/68/8f/e6688f4eaec9de6db74b9dd19b8b3745.jpg",
//    "https://i.pinimg.com/236x/59/1d/a6/591da6d4176c1639176245e3256289c0.jpg",
//    "https://i.pinimg.com/236x/c3/be/fc/c3befc7e936594ed41ae680367e3d097.jpg",
//    "https://i.pinimg.com/236x/3c/c6/d8/3cc6d8dc97b64df42a3108c48d6304eb.jpg"
//)

