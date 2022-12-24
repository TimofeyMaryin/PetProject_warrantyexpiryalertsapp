package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.BACKGROUND
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.realproject.warrantyexpiryalertsapp.utils.LIST_OF_HINT_MODEL
import androidx.compose.foundation.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardHintElement(
    modifier: Modifier,
    viewModel: MainViewModel
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

        items(LIST_OF_HINT_MODEL.size) {
            val currentHintItem = LIST_OF_HINT_MODEL[it]
            Box(
                modifier = Modifier
                    .height(170.dp)
                    .fillParentMaxWidth()
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK))
                        .fillMaxWidth(.9f)
                        .defaultMinSize(minHeight = ApplicationUiConst.SizeObject.HEIGHT_HINT_CARD)
                        .background(BACKGROUND)
                        .border(
                            BorderStroke(2.dp, SURFACE.copy(1f)),
                            RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK)
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Box(modifier = Modifier.fillMaxSize().weight(1f), contentAlignment = Alignment.BottomCenter) {
                            Image(
                                painter = painterResource(id = currentHintItem.image),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp)
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = ApplicationUiConst.Padding.VERY_LARGE),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            MediumBoldText(text = currentHintItem.title)
                            SmallLightText(text = currentHintItem.hintText)
                        }
                    }
                }
            }
        }
    }
}