package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.ApplicationTextField
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog.AlertDialogContainer
import android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog.AlertSelectWayGetImage
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.BACKGROUND
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_GUARANTEE
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_NAME
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_PRICE
import android.service.autofill.OnClickAction
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import kotlin.random.Random
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateProductFragment(
    navController: NavController,
    viewModel: CreateUserProductViewModel
){

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))
    val generateRandomNum by remember { mutableStateOf(Random.nextInt(0, 9999)) }
    var openBottomSheet by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = openBottomSheet, key2 = bottomSheetScaffoldState){
        if(openBottomSheet) {
            if(bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                bottomSheetScaffoldState.bottomSheetState.expand()
            } else {
                bottomSheetScaffoldState.bottomSheetState.collapse()
            }
        }
    }
    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(text = "Hello from sheet")
            }
        }, sheetPeekHeight = 0.dp
    ) {

        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (topBar, userFillData) = createRefs()

            SmallApplicationHeader(
                titlePreviousFragment = "Создать",
                titleCurrentFragment = "Елемент №$generateRandomNum",
                navController = navController,
                onCLick = { navController.navigate(Screen.SettingsScreen.route) },
                iconRes = R.drawable.ic_settings,
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = ApplicationUiConst.Padding.LARGE)
                    .constrainAs(userFillData) {
                        top.linkTo(topBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Container {
                    ApplicationTextField(
                        value = viewModel.productName,
                        placeHolder = "Укажите название продукта",
                        onValueChange = { viewModel.changeValue(INDEX_PRODUCT_NAME, it) },
                        modifier = Modifier.fillMaxWidth()
                    )

                }
                Container {
                    ApplicationTextField(
                        value = viewModel.guaranteePeriod.toString(),
                        placeHolder = "Укажите срок гарантии(в мес)",
                        onValueChange = {
                            if(it.isDigitsOnly()) {
                                viewModel.changeValue(INDEX_PRODUCT_GUARANTEE, it)
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardType = KeyboardType.Number
                    )
                }
                Container {
                    ApplicationTextField(
                        value = viewModel.dateOfBuyProduct,
                        placeHolder = "Укажите дату покупки",
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Container {
                    CreateElementTextField(
                        onClickAction = { /*TODO*/ },
                        text = "Выбери категорию",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = ApplicationUiConst.Padding.BIG)
                    )
                }
                Container {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ApplicationTextField(
                            value = viewModel.productPrice.toString(),
                            placeHolder = "Укажите цену продукта",
                            onValueChange = {
                                if(it.isDigitsOnly()) {
                                    viewModel.changeValue(INDEX_PRODUCT_PRICE, it)
                                }
                            },
                            modifier = Modifier
                                .weight(7f)
                                .padding(end = ApplicationUiConst.Padding.SMALL),
                            keyboardType = KeyboardType.Number
                        )

                        CreateElementTextField(
                            onClickAction = { /*TODO*/ },
                            text = "$",
                            modifier = Modifier.weight(3f),
                            textAlign = TextAlign.Center
                        )

                    }

                }
                Container {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                viewModel.openDialog = true
                            }
                            .height(ApplicationUiConst.SizeObject.HEIGHT_CARD)
                            .border(
                                BorderStroke(2.dp, SURFACE),
                                RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Column(
                            modifier = Modifier.fillMaxWidth(.5f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(painter = painterResource(id = R.drawable.ic_add_circle), contentDescription = null)
                            SmallLightText(text = "Добавить фото")
                        }

                    }
                }
            }

        }

    }
    if(viewModel.openDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.openDialog = false },
            text = {
                AlertSelectWayGetImage(
                    fromArchive = {

                    },
                    fromGallery = {
                        openBottomSheet = true
                        viewModel.openDialog = false
                    }
                )
            },
            confirmButton = {},
            modifier = Modifier
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK)),
            backgroundColor = BACKGROUND
        )
    }

}


@Composable
private fun CreateElementTextField(
    onClickAction: () -> Unit,
    text: String,
    modifier: Modifier,
    textAlign: TextAlign = TextAlign.Start,
) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK))
            .border(
                BorderStroke(2.dp, SURFACE),
                RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK)
            )
            .clickable { onClickAction() }
            .then(modifier),
        contentAlignment = Alignment.CenterStart
    ) {
        SmallLightText(
            text = text,
            modifier = Modifier.fillMaxWidth(),
            textAlign = textAlign
        )
    }
}