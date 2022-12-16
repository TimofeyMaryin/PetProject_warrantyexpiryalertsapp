package android.realproject.warrantyexpiryalertsapp.ui.elements

import android.graphics.drawable.shapes.Shape
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun ApplicationTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    icon: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        placeholder = {
            SmallLightText(text = placeHolder)
        },
        shape = CircleShape,
        trailingIcon = { Icon(painter = painterResource(id = icon), contentDescription = null, tint = PRIMARY) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = PRIMARY,
            disabledLabelColor = PRIMARY_70,

            ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    )
}


@Composable
fun ApplicationTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        placeholder = {
            SmallLightText(text = placeHolder)
        },
        shape = CircleShape,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = PRIMARY,
            disabledLabelColor = PRIMARY_70,

            ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    )
}



@Composable
fun ApplicationTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeHolder: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        modifier = modifier,
        singleLine = true,
        placeholder = {
            SmallLightText(text = placeHolder)
        },
        shape = CircleShape,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = PRIMARY,
            disabledLabelColor = PRIMARY_70,

            ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}


