package android.realproject.warrantyexpiryalertsapp.ui.elements.alert_dialog

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun AlertDialogContainer(
    openDialog: Boolean,
    content: @Composable () -> Unit,
) {

    if(openDialog) {
        AlertDialog(
            onDismissRequest = { },
            text = { content() },
            confirmButton = {},
            modifier = Modifier.fillMaxWidth(.5f)
        )
    }

}