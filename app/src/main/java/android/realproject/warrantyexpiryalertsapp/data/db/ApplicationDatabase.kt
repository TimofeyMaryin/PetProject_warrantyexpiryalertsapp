package android.realproject.warrantyexpiryalertsapp.data.db

import android.app.Application
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyDao
import android.realproject.warrantyexpiryalertsapp.data.db.product.ProductsUnderWarrantyEntity
import android.realproject.warrantyexpiryalertsapp.data.db.user_info.UserDao
import android.realproject.warrantyexpiryalertsapp.data.db.user_info.UserEntity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [
        ProductsUnderWarrantyEntity::class,
        UserEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class ApplicationDatabase: RoomDatabase() {

    abstract fun productDao(): ProductsUnderWarrantyDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile var INSTANCE: ApplicationDatabase? = null

        fun getInstance(application: Application): ApplicationDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        application,
                        ApplicationDatabase::class.java,
                        "database.dp"
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }

                INSTANCE = instance
                return INSTANCE!!
            }
        }


    }

}