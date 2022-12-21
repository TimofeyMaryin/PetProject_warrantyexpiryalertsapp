package android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.*
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.launch

@Composable
fun AlertDialogEditDesc(
    viewModel: MainViewModel,
    productElement: ProductsUnderWarrantyEntity
) {
    val coroutineScope = rememberCoroutineScope()

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (editText, buttonPlace, header, delIcon) = createRefs()
        val context = LocalContext.current
        var descText by remember { mutableStateOf(productElement.addiction ?: "") }

        MediumLightText(
            text = "Давай изменить эту белеберду",
            modifier = Modifier.constrainAs(header) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            },
        )

        TextField(
            value = descText,
            onValueChange = { descText = it },
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = ApplicationUiConst.SizeObject.HEIGHT_EDIT_TEXT)
                .constrainAs(editText) {
                    top.linkTo(parent.top)
                    bottom.linkTo(buttonPlace.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colors = TextFieldDefaults.textFieldColors(
                textColor = PRIMARY_70,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            ),
            placeholder = {
                SmallLightText(text = "Давай, пиши уже что-нибудь....")
            }
        )

        IconButton(
            onClick = { descText = "" },
            modifier = Modifier.constrainAs(delIcon) {
                top.linkTo(editText.bottom, margin = ApplicationUiConst.Padding.BIG)
                end.linkTo(parent.end)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_trash),
                contentDescription = null,
                modifier =  Modifier.size(ApplicationUiConst.SizeObject.ICON_SIZE),
                tint = DANGEROUS
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonPlace) {
                    bottom.linkTo(parent.bottom)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(
                onClick = { viewModel.openAlertEditDesc = false },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PRIMARY_70,
                )
            ) {
                SmallLightText(text = "Отмена", color = SECONDARY)
            }

            Button(
                onClick = {
                    coroutineScope.launch {
                        val updateProduct = productElement.copy(addiction = descText)
                        viewModel.updateProductElement(product = updateProduct)
                        viewModel.openAlertEditDesc = false
                        viewModel.popBackStack()
                    }

                    Toast.makeText(context, "Изменения вступили в силу", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = PRIMARY,
                ),
                shape = RoundedCornerShape(0)
            ) {
                SmallLightText(text = "Сохранить", color = SECONDARY)
            }

        }

    }


}