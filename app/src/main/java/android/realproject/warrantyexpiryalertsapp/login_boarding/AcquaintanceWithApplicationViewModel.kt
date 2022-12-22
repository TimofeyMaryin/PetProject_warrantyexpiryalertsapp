package android.realproject.warrantyexpiryalertsapp.login_boarding

import android.icu.util.Calendar
import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.utils.LIST_OF_ICON_BOARDING
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import kotlin.random.Random

class AcquaintanceWithApplicationViewModel: ViewModel() {

    fun getRandomIcon(): Int = LIST_OF_ICON_BOARDING[Random.nextInt(0, LIST_OF_ICON_BOARDING.size)]

    var firstName by mutableStateOf("")
    var secondName by mutableStateOf("")
    var avatarUri by mutableStateOf("")
    var headerUri by mutableStateOf("")

    val hintList = listOf(
        HintModel("Create model", R.raw.anim_one),
        HintModel("Delete model", R.raw.anim_two),
        HintModel("Edit model", R.raw.anim_three),
        HintModel("Show your profile", R.raw.anim_one),
    )

    val avatarImages = listOf(
        "https://i.pinimg.com/564x/7c/6d/85/7c6d8558ad8abb16cb651892c6f090bd.jpg",
        "https://i.pinimg.com/236x/25/b0/4f/25b04f1aa86b45e54280320ab895760c.jpg",
        "https://i.pinimg.com/236x/16/44/e5/1644e54c5f15d57bb84fdb7657faa4f4.jpg",
        "https://i.pinimg.com/236x/fc/78/66/fc7866aa0cbc8a6ff6d5162581197e3a.jpg",
        "https://i.pinimg.com/236x/be/96/dd/be96dd33bf07eb925b16cf128b165e64.jpg",
        "https://i.pinimg.com/236x/21/dd/9a/21dd9a7577685cf89f0427ae52f3222f.jpg",
        "https://i.pinimg.com/236x/1a/d2/da/1ad2da7dac8e002c5bd8d7d624833638.jpg",
        "https://i.pinimg.com/236x/95/9f/14/959f147a37be14015b965abd345dc85b.jpg",
        "https://i.pinimg.com/236x/95/9f/14/959f147a37be14015b965abd345dc85b.jpg",
        "https://i.pinimg.com/236x/ae/a6/0e/aea60e3564605852d6f4dbbbb38a9244.jpg",
        "https://i.pinimg.com/236x/f1/28/09/f12809e6e90d25140d3537c0e7784695.jpg",
        "https://i.pinimg.com/236x/55/ea/a0/55eaa07d4c45a5a1d7953f8536808d40.jpg",
        "https://i.pinimg.com/236x/a0/72/84/a07284fd08e967927539112b8bf55cf0.jpg",
        "https://i.pinimg.com/236x/86/95/54/8695540db1e9224367ed9d1a4884ccfc.jpg",
        "https://i.pinimg.com/236x/c2/cd/b3/c2cdb3d4b850e2bab9ccb3545fef7694.jpg",
        "https://i.pinimg.com/236x/cc/bc/d1/ccbcd1baf6dd56c6ec0b923ff392a157.jpg",
        "https://i.pinimg.com/236x/43/37/21/4337214a7351db3fe16cfade47d0e6c1.jpg",
        "https://i.pinimg.com/236x/32/18/29/321829ef07b414c2b1b011c4682958b1.jpg",
        "https://i.pinimg.com/236x/ac/e6/ab/ace6ab301845d8cd03ee0db6d4c71801.jpg",
        "https://i.pinimg.com/236x/e7/5f/8f/e75f8ff1c1a520c95539f2fd3a23a61e.jpg",
        "https://i.pinimg.com/236x/e7/5f/8f/e75f8ff1c1a520c95539f2fd3a23a61e.jpg",
        "https://i.pinimg.com/236x/60/0a/c7/600ac79e908c025778c490381eea5568.jpg",
    )

    val headerImages = listOf(
        "https://i.pinimg.com/236x/d2/b4/57/d2b4577b329a181e9d721d7418630e8f.jpg",
        "https://i.pinimg.com/236x/36/1a/d0/361ad0a308cbcd01a310ac47e2021cac.jpg",
        "https://i.pinimg.com/236x/20/10/25/20102576dada7dec7eeb4d06b0cbe099.jpg",
        "https://i.pinimg.com/236x/ed/90/dd/ed90dd9c8f865871420e2b48f676cb7b.jpg",
        "https://i.pinimg.com/236x/1b/a3/18/1ba3189f818747b4db12c75fb9069510.jpg",
        "https://i.pinimg.com/236x/4d/b2/5c/4db25c6cd8966be754b3733111058772.jpg",
        "https://i.pinimg.com/236x/69/d9/b9/69d9b9610f4d7482376ef0fd8d9bf3f4.jpg",
        "https://i.pinimg.com/236x/e0/e2/07/e0e2071dae703cc45f72b4ec4c3d34c5.jpg",
        "https://i.pinimg.com/236x/19/56/6d/19566d7b1056436f413baa1218c20af6.jpg",
        "https://i.pinimg.com/236x/e5/11/fb/e511fb7dede6d64d8ae6796c8475f467.jpg",
        "https://i.pinimg.com/236x/1f/6b/7f/1f6b7faaa0651d4f2373302c8e3ee838.jpg",
    )

    fun dateOfRegister(): String = LocalDateTime.now().toString()
}