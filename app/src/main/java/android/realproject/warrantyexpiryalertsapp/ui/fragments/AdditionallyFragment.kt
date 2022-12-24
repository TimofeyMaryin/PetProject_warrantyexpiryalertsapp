package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.annotation.SuppressLint
import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import android.realproject.warrantyexpiryalertsapp.utils.ADDITIONALLY_APPLICATION_ITEM
import android.text.Html
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController

@Composable
fun AdditionallyFragment(
    index: Int,
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        SmallApplicationHeader(
            titlePreviousFragment = "Доп инфа",
            titleCurrentFragment = stringResource(id = ADDITIONALLY_APPLICATION_ITEM[index].title),
            navController = navController
        )
        Container {
            MediumBoldText(
                text = stringResource(id = ADDITIONALLY_APPLICATION_ITEM[index].title),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Container {
            SmallLightText(text = stringResource(id = ADDITIONALLY_APPLICATION_ITEM[index].mainContent))
        }
    }


}


