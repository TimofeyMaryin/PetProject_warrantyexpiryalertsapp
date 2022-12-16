package android.realproject.warrantyexpiryalertsapp.utils

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.model.AdditionallyApplicationModel

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