package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.CreateUserProductViewModel
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.ApplicationTextField
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog.AlertDialogSelectCategory
import android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog.AlertSelectWayGetImage
import android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog.DialogSelectCurrency
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.BACKGROUND
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import android.realproject.warrantyexpiryalertsapp.ui.theme.SECONDARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_GUARANTEE
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_NAME
import android.realproject.warrantyexpiryalertsapp.utils.INDEX_PRODUCT_PRICE
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import kotlin.random.Random
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import java.util.Date

@Composable
fun CreateProductFragment(
    navController: NavController,
    viewModel: CreateUserProductViewModel,
    mainViewModel: MainViewModel,
){

    val generateRandomNum by remember { mutableStateOf(Random.nextInt(0, 9999)) }
    val context = LocalContext.current
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> viewModel.imageModel = uri }
    )


    val coroutineScope = rememberCoroutineScope()

    val calendar = Calendar.getInstance()
    val dayOfMonth: Int = calendar.get(Calendar.DAY_OF_MONTH)
    val month: Int = calendar.get(Calendar.MONTH)
    val year: Int = calendar.get(Calendar.YEAR)
    calendar.time = Date()

    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            viewModel.dateOfBuyProduct = "$dayOfMonth/$month/$year"
        }, year, month, dayOfMonth
    )

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
         LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ApplicationUiConst.Padding.LARGE)
                .constrainAs(userFillData) {
                    top.linkTo(topBar.bottom, margin = ApplicationUiConst.Padding.EXTRA_LARGE)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
             item {
                 Container {
                     ApplicationTextField(
                         value = viewModel.productName,
                         placeHolder = "Укажите название продукта",
                         onValueChange = { viewModel.changeValue(INDEX_PRODUCT_NAME, it) },
                         modifier = Modifier.fillMaxWidth(),
                         singleLine = true
                     )

                 }
             }

             item {
                 Container {
                     ApplicationTextField(
                         value = viewModel.guaranteePeriod,
                         placeHolder = "Укажите срок гарантии(в мес)",
                         onValueChange = {
                             if (it.isDigitsOnly()) {
                                 viewModel.changeValue(INDEX_PRODUCT_GUARANTEE, it)
                             }
                         },
                         modifier = Modifier.fillMaxWidth(),
                         keyboardType = KeyboardType.Number,

                     )
                 }
             }
             item {
                 Container {
                     ApplicationTextField(
                         value = viewModel.dateOfBuyProduct,
                         placeHolder = "Укажите дату покупки",
                         modifier = Modifier.fillMaxWidth(),
                     )
                     CreateElementTextField(
                         onClickAction = {
                             datePicker.show()
                         },
                     )
                 }
             }

             item {
                 Container {

                     ApplicationTextField(
                         value = viewModel.category,
                         placeHolder = "Выбери категорию",
                         modifier = Modifier.fillMaxWidth()
                     )
                     CreateElementTextField(
                         onClickAction = {
                             viewModel.openDialogSelectCategory = true
                         },
                     )
                 }

             }

             item {
                 Container {
                     Row(
                         modifier = Modifier.fillMaxWidth(),
                         horizontalArrangement = Arrangement.SpaceBetween,
                         verticalAlignment = Alignment.CenterVertically,
                     ) {
                         ApplicationTextField(
                             value = viewModel.productPrice,
                             placeHolder = "Укажите цену продукта",
                             onValueChange = {
                                 if (it.isDigitsOnly()) {
                                     viewModel.changeValue(INDEX_PRODUCT_PRICE, it)
                                 }
                             },
                             modifier = Modifier
                                 .weight(7f)
                                 .padding(end = ApplicationUiConst.Padding.SMALL),
                             keyboardType = KeyboardType.Number
                         )

                         CreateElementTextField(
                             onClickAction = { viewModel.openDialogSelectCurrency = true },
                             text = viewModel.currency,
                             modifier = Modifier
                                 .weight(3f)
                                 .background(SECONDARY),
                             textAlign = TextAlign.Center
                         )

                     }

                 }
             }

             item {
                 Container {
                     ApplicationTextField(
                         value = viewModel.description,
                         placeHolder = "Описание *необязательно",
                         onValueChange = { viewModel.description = it },
                         modifier = Modifier.fillMaxWidth()
                     )
                 }
             }

             item {
                 Container {
                     Box(
                         modifier = Modifier
                             .fillMaxWidth()
                             .clickable {
                                 viewModel.openDialogSelectImage = true
                             }
                             .height(ApplicationUiConst.SizeObject.HEIGHT_CARD)
                             .border(
                                 BorderStroke(2.dp, SURFACE),
                                 RoundedCornerShape(ApplicationUiConst.Rounded.SMALL)
                             ),
                         contentAlignment = Alignment.Center
                     ) {
                         if (viewModel.imageModel == null) {
                             Column(
                                 modifier = Modifier.fillMaxWidth(.5f),
                                 horizontalAlignment = Alignment.CenterHorizontally
                             ) {
                                 Icon(
                                     painter = painterResource(id = R.drawable.ic_add_circle),
                                     contentDescription = null
                                 )
                                 SmallLightText(text = "Добавить фото")
                             }
                         } else {
                             AsyncImage(
                                 model = viewModel.imageModel,
                                 contentDescription = null,
                                 modifier = Modifier
                                     .fillMaxSize()
                                     .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL)),
                                 contentScale = ContentScale.Crop
                             )
                         }


                     }
                 }
             }

             item {
                 if(
                     viewModel.productName != "" &&
                     viewModel.guaranteePeriod != ""&&
                     viewModel.dateOfBuyProduct != "" &&
                     viewModel.category != "" &&
                     viewModel.productName != "" &&
                     viewModel.imageModel != null
                 ) {
                     Container {
                         Button(
                             onClick = {
                                coroutineScope.launch {
                                    mainViewModel.insertProduct(
                                        ProductsUnderWarrantyEntity(
                                            productName = viewModel.productName,
                                            imagesProduct = viewModel.imageModel ?: "",
                                            guaranteePeriod = viewModel.guaranteePeriod,
                                            category = viewModel.category,
                                            addiction = viewModel.description,
                                            dateOfPurchaseOfTheProduct = viewModel.dateOfBuyProduct
                                        )
                                    )

                                }
                                 navController.navigate(Screen.MainScreen.route)
                                 Toast.makeText(context, "Вы создали первую карточку, поздравляю вас!!", Toast.LENGTH_SHORT).show()
                             },
                             modifier = Modifier.fillMaxWidth(),
                             colors = ButtonDefaults.buttonColors(
                                 backgroundColor = SECONDARY,
                                 contentColor = BACKGROUND
                             ),
                             shape = RoundedCornerShape(ApplicationUiConst.Rounded.SMALL)
                             ) {
                             MediumBoldText(text = "Создать")
                         }

                     }
                 }
             }

             item {
                 Box(modifier = Modifier
                     .fillMaxWidth()
                     .height(200.dp))
             }


        }
    }


    if(viewModel.openDialogSelectImage) {
        AlertDialog(
            onDismissRequest = { viewModel.openDialogSelectImage = false },
            buttons = {
                AlertSelectWayGetImage(
                    fromArchive = {
                        navController.navigate(Screen.SelectImageFromArchiveScreen.route)
                        viewModel.openDialogSelectImage = false
                    },
                    fromGallery = {
                        photoPickerLauncher.launch (
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                        viewModel.openDialogSelectImage = false

                    }
                )
            },
            modifier = Modifier
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK))
                .fillMaxHeight(.5f),
            backgroundColor = BACKGROUND
        )
    }

    if(viewModel.openDialogSelectCurrency) {
        AlertDialog(
            onDismissRequest = { viewModel.openDialogSelectCurrency = false },
            buttons = {
                DialogSelectCurrency(viewModel = viewModel)
            },
            modifier = Modifier
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK))
                .fillMaxHeight(.7f),
            backgroundColor = BACKGROUND
        )
    }

    if(viewModel.openDialogSelectCategory){
        AlertDialog(
            onDismissRequest = { viewModel.openDialogSelectCategory = false },
            buttons = {
                AlertDialogSelectCategory(
                    viewModel = viewModel,
                    mainViewModel = mainViewModel,
                )
            },
            modifier = Modifier
                .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK))
                .fillMaxHeight(.7f),
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
            .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
            .border(
                BorderStroke(2.dp, SURFACE),
                RoundedCornerShape(ApplicationUiConst.Rounded.SMALL)
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

@Composable
private fun CreateElementTextField(
    onClickAction: () -> Unit,
) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .clip(RoundedCornerShape(ApplicationUiConst.Rounded.SMALL))
            .clickable { onClickAction() }
            .fillMaxWidth(),
    )
}