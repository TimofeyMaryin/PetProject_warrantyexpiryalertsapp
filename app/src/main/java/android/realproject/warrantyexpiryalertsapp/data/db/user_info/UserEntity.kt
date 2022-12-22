package android.realproject.warrantyexpiryalertsapp.data.db.user_info

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * UserEntity()
 *
 * firstName - имя чела
 * secondName - фамилия чела
 * dateRegister - дата регистрации (программа сама это заоплняет)
 * avatar - аватарка чела
 * status - просто статус чела
 *
 * Да ебнулись чтоль, нахуй это комментировать?
 */


@Entity
data class UserEntity(
    @PrimaryKey var id: Long = 0,
    @ColumnInfo var firstName: String? = null,
    @ColumnInfo var secondName: String? = null,
    @ColumnInfo val dateRegister: String? = null,
    @ColumnInfo var avatar: String? = null,
    @ColumnInfo var status: String? = null,
    @ColumnInfo var headerImage: String? = null
)
