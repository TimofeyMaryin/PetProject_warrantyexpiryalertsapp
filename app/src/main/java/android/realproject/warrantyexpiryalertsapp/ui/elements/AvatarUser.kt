package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage

@Composable
fun AvatarUser(
    viewModel: MainViewModel,
    modifier: Modifier
) {
    if(viewModel.getUser() != null && viewModel.getUser().avatar != null){
        Box(
            modifier = Modifier
                .size(ApplicationUiConst.SizeObject.AVATAR_SIZE)
                .then(modifier),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = viewModel.getUser().avatar,
                contentDescription = null,
                modifier = Modifier.clip(CircleShape).fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    } else {
        Box(
            modifier = Modifier
                .size(ApplicationUiConst.SizeObject.AVATAR_SIZE)
                .then(modifier),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(model = R.drawable.default_avatar, contentDescription = null, modifier = Modifier.clip(CircleShape))
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null, tint = SURFACE)
        }
    }

}