package android.realproject.warrantyexpiryalertsapp.ui.fragments

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.Container
import android.realproject.warrantyexpiryalertsapp.ui.elements.SmallApplicationHeader
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.ui.theme.DANGEROUS
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY
import android.realproject.warrantyexpiryalertsapp.ui.theme.PRIMARY_70
import android.realproject.warrantyexpiryalertsapp.ui.theme.SURFACE
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kotlinx.coroutines.launch

@Composable
fun DetailsProductFragment(
    product: ProductsUnderWarrantyEntity?,
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    if(product != null){
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
                SmallApplicationHeader(
                    titlePreviousFragment = "Продукт",
                    titleCurrentFragment = product.productName,
                    navController = viewModel.navController
                )
            }
            item {

                AsyncImage(
                    model = product.imageSrc,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }

            item {
                DetailsItem(
                    titleCategory = "Название продукта",
                    content = product.productName,
                    weighForTitle = 1f,
                    weightForLine = 1f,
                    weightForContent = .8f
                )
            }
            item {
                DetailsItem(
                    titleCategory = "Дата окончания гарантии",
                    content = viewModel.checkTimeOutWarranty(
                        product.dateOfPurchaseOfTheProduct,
                        product.guaranteePeriod
                    ),
                    weighForTitle = 2f,
                    weightForLine = .8f,
                    weightForContent = 1f
                )
            }

            item {
                DetailsItem(
                    titleCategory = "Дата покупки товара",
                    content = product.dateOfPurchaseOfTheProduct,
                    weighForTitle = 2f,
                    weightForLine = 1f,
                    weightForContent = 1f
                )
            }
            item {
                DetailsItem(
                    titleCategory = "Цена",
                    content = "${product.productPrice} ${product.currency}",
                    weightForContent = .8f,
                    weightForLine = 2f,
                    weighForTitle = .8f
                )
            }
            item {
                SmallLightText(text = "Дополнительная информация", color = PRIMARY_70)
            }
            item {
                Container {
                    ConstraintLayout(
                        modifier = Modifier
                            .clip(RoundedCornerShape(ApplicationUiConst.Rounded.BLOCK))
                            .fillMaxWidth()
                            .background(SURFACE),
                    ) {
                        val (content, iconEditText) = createRefs()

                        SmallLightText(
                            text = product.addiction ?: "Еще не поздно добавить описание)))",
                            color = PRIMARY,
                            modifier = Modifier.constrainAs(content){
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                bottom.linkTo(parent.bottom)
                                end.linkTo(parent.end)
                            }.background(Color.Red),
                            textAlign = TextAlign.Center
                        )

                        IconButton(
                            onClick = { },
                            modifier = Modifier.constrainAs(iconEditText) {
                                top.linkTo(parent.top, margin = ApplicationUiConst.Padding.SMALL)
                                end.linkTo(parent.end, margin = ApplicationUiConst.Padding.SMALL)
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit_mode),
                                contentDescription = null,
                                tint = PRIMARY,
                            )
                        }
                    }
                }

            }

            item {
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd
                ) {
                    Container {
                        IconButton(onClick = {
                            viewModel.popBackStack()
                            Toast.makeText(context, "Вы успешнро удалили карточку...", Toast.LENGTH_SHORT).show()
                            coroutineScope.launch {
                                viewModel.deleteProduct(product)
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_trash),
                                contentDescription = null,
                                tint = DANGEROUS
                            )
                        }
                    }
                }

            }

            item {
                Box(modifier = Modifier.fillMaxWidth().height(300.dp))
            }

        }

    }
}

@Composable
private fun DetailsItem(
    titleCategory: String,
    content: String,
    weighForTitle: Float,
    weightForLine: Float,
    weightForContent: Float
) {
    Container {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SmallLightText(
                text = titleCategory,
                color = PRIMARY_70,
                modifier = Modifier.weight(weighForTitle)
            )

            Box(modifier = Modifier
                .height(2.dp)
                .weight(weightForLine)
                .background(PRIMARY_70))

            SmallLightText(
                text = content,
                color = PRIMARY,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(weightForContent),
                textAlign = TextAlign.End
            )

        }

    }
}