package android.realproject.warrantyexpiryalertsapp.data.db.user_info

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update

interface UserImpl {

    suspend fun insertUser(user: UserEntity)
    suspend fun updateUserInfo(user: UserEntity)
    suspend fun deleteUser(user: UserEntity)
    fun getUser(): UserEntity

}