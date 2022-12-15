package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.graphics.drawable.shapes.Shape
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun ApplicationTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    icon: Int,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        placeholder = {
            MediumLightText(text = placeHolder)
        },
        shape = CircleShape,
        trailingIcon = { Icon(painter = painterResource(id = icon), contentDescription = null, tint = PRIMARY) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = PRIMARY,
            disabledLabelColor = PRIMARY_70,

        ),
    )
}