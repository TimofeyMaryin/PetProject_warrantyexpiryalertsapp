package android.realproject.warrantyexpiryalertsapp.data.db.user_info

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.selects.select


@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Update
    suspend fun updateUserInfo(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("select * from userentity")
    fun getUser(): UserEntity

}