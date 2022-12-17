package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.BACKGROUND
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardHintElement(
    modifier: Modifier
) {
    val state = rememberLazyListState()
    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        state = state,
        flingBehavior = flingBehavior
    ) {
        items(4) {
            Box(
                modifier = Modifier
                    .height(170.dp)
                    .fillParentMaxWidth()
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape( ApplicationUiConst.Rounded.BLOCK))
                        .fillMaxWidth(.9f)
                        .background(BACKGROUND)
                        .border(BorderStroke(2.dp, SURFACE.copy(1f)), RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK)),
                    contentAlignment = Alignment.Center
                ){
                    val random by remember {
                        mutableStateOf(Random.nextInt(4, 23))
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(.6f).padding(vertical = ApplicationUiConst.Padding.VERY_LARGE),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        MediumBoldText(text = "Hint №$it")
                        SmallLightText(text = "qwerty ".repeat(random))
                    }
                }
            }
        }
    }
}