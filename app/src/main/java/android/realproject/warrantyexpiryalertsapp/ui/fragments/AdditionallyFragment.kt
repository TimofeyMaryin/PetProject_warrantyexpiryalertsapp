package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.realproject.warrantyexpiryalertsapp.utils.ADDITIONALLY_APPLICATION_ITEM
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun AdditionallyFragment(
    index: Int
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = stringResource(id = ADDITIONALLY_APPLICATION_ITEM[index].title), style = MaterialTheme.typography.h3)
    }
}