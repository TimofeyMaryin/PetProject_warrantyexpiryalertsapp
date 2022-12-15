package android.realproject.warrantyexpiryalertsapp.ui.elements.animation

import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment



@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TransitionUnderFragment(
    fragment: @Composable () -> Unit
) {


    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(
            initialOffsetY = { -40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        content = fragment,
        initiallyVisible = false
    )

}