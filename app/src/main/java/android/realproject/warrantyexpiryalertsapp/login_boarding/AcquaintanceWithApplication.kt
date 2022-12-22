package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AcquaintanceWithApplication(
    viewModel: AcquaintanceWithApplicationViewModel,
    mainViewModel: MainViewModel,
    navController: NavController
) {

    val state = rememberLazyListState()
    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)

    LazyRow(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        state = state,
        flingBehavior = flingBehavior
    ){
        // Znakomstvo
        item {
            AcquaintanceWithApplicationFragment(viewModel = viewModel, modifier = Modifier.fillParentMaxSize())
        }

        /// Description
        item {
            DescriptionAboutApplicationFragment(viewModel = viewModel, modifier = Modifier.fillParentMaxSize())
        }


        // Fill user date

        item {
            FillUserDataFragment(
                viewModel = mainViewModel,
                aViewModel = viewModel,
                modifier = Modifier.fillParentMaxSize(),
                navController = navController
            )

        }
    }


}