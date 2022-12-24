package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun SmallApplicationHeader(
    titlePreviousFragment: String,
    titleCurrentFragment: String,
    navController: NavController,
    modifier: Modifier = Modifier,
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(ApplicationUiConst.SizeObject.HEIGHT_HEADER)
            .background(SURFACE)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        MediumLightText(
            text = "$titlePreviousFragment > ",
            modifier = Modifier.clickable { navController.popBackStack() }.padding(start = ApplicationUiConst.Padding.BIG)
        )
        MediumLightText(text = titleCurrentFragment, color = SECONDARY)

    }

}

@Composable
fun SmallApplicationHeader(
    titlePreviousFragment: String,
    titleCurrentFragment: String,
    onCLick: () -> Unit,
    iconRes: Int,
    navController: NavController,
    modifier: Modifier = Modifier,
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(ApplicationUiConst.SizeObject.HEIGHT_HEADER)
            .background(SURFACE)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(start = ApplicationUiConst.Padding.BIG),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            MediumLightText(
                text = "$titlePreviousFragment > ",
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            MediumLightText(text = titleCurrentFragment, color = SECONDARY)
        }
        IconButton(
            onClick = { onCLick() },
            modifier = Modifier.padding(end = ApplicationUiConst.Padding.BIG)
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = PRIMARY,
                modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE)
            )
        }

    }
}

@Composable
fun SmallApplicationHeader(
    titlePreviousFragment: String,
    titleCurrentFragment: String,
    onCLickShare: () -> Unit,
    onCLickSetting: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,

){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(ApplicationUiConst.SizeObject.HEIGHT_HEADER)
            .background(SURFACE)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Row(
            modifier = Modifier.weight(6f).padding(start = ApplicationUiConst.Padding.BIG),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            MediumLightText(
                text = "$titlePreviousFragment > ",
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            MediumLightText(text = titleCurrentFragment, color = SECONDARY)
        }

        Row(
            modifier = Modifier.weight(4f).padding(end = ApplicationUiConst.Padding.BIG),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { onCLickShare() },
                modifier = Modifier.padding(vertical = ApplicationUiConst.Padding.LARGE)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = null,
                    tint = PRIMARY,
                    modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE)
                )
            }

            IconButton(
                onClick = { onCLickSetting() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = null,
                    tint = PRIMARY,
                    modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE)
                )
            }

        }

    }
}


@Composable
fun SmallApplicationHeader(
    titlePreviousFragment: String,
    titleCurrentFragment: String,
    onCLick: () -> Unit,
    onClickUndo: () -> Unit,
    iconRes: Int,
    modifier: Modifier = Modifier,
){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(ApplicationUiConst.SizeObject.HEIGHT_HEADER)
            .background(SURFACE)
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.padding(start = ApplicationUiConst.Padding.BIG),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            MediumLightText(
                text = "$titlePreviousFragment > ",
                modifier = Modifier.clickable { onClickUndo() }
            )
            MediumLightText(text = titleCurrentFragment, color = SECONDARY)
        }
        IconButton(
            onClick = { onCLick() },
            modifier = Modifier.padding(end = ApplicationUiConst.Padding.BIG)
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                tint = PRIMARY,
                modifier = Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE)
            )
        }

    }
}

