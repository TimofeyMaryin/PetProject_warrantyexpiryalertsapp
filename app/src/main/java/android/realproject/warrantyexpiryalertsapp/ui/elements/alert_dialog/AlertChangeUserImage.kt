package android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog

import android.realproject.warrantyexpiryalertsapp.data.navigation.Screen
import android.realproject.warrantyexpiryalertsapp.data.view_model.MainViewModel
import android.realproject.warrantyexpiryalertsapp.login_boarding.AcquaintanceWithApplicationViewModel
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumBoldText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.MediumLightText
import android.realproject.warrantyexpiryalertsapp.ui.elements.text.SmallLightText
import android.realproject.warrantyexpiryalertsapp.utils.ApplicationUiConst
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun AlertChangeUserImage(
    navController: NavController,
    viewModel: MainViewModel,
    aViewModel: AcquaintanceWithApplicationViewModel,
) {
    val coroutineScope = rememberCoroutineScope()
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (title, content) = createRefs()

        MediumBoldText(text = "Давай изменим твой видОк", modifier =Modifier.constrainAs(title) {
            top.linkTo(parent.top, margin = ApplicationUiConst.Padding.LARGE)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(content) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ApplicationUiConst.SizeObject.HEIGHT_EDIT_TEXT)
                        .clickable {
                            navController.navigate("${Screen.SelectUserPhoto.route}/1")
                            viewModel.openAlertChangeUserPhoto = false


                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MediumLightText(
                        text = "Изменить аватарку",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ApplicationUiConst.SizeObject.HEIGHT_EDIT_TEXT)
                        .clickable {
                            viewModel.openAlertChangeUserPhoto = false
                            navController.navigate("${Screen.SelectUserPhoto.route}/0")
                            viewModel.openAlertChangeUserPhoto = false
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MediumLightText(
                        text = "Изменить шапОчку",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ApplicationUiConst.SizeObject.HEIGHT_EDIT_TEXT)
                        .clickable {
                            coroutineScope.launch {
                                viewModel.updateUserInfo(
                                    user = viewModel
                                        .getUser()
                                        .copy(
                                            avatar = null
                                        )
                                )
                                viewModel.openAlertChangeUserPhoto = false
                            }


                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MediumLightText(
                        text = "Удалить аватарку",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ApplicationUiConst.SizeObject.HEIGHT_EDIT_TEXT)
                        .clickable {
                            coroutineScope.launch {
                                viewModel.updateUserInfo(
                                    user = viewModel
                                        .getUser()
                                        .copy(
                                            headerImage = null
                                        )
                                )
                                viewModel.openAlertChangeUserPhoto = false
                            }
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MediumLightText(
                        text = "Удалить шапочку",
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                }

            }
        }
    }
}