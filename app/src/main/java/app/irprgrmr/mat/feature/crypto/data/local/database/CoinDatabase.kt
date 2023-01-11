package app.irprgrmr.mat.feature.crypto.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.irprgrmr.mat.feature.crypto.data.local.dataAccessObject.CoinDao
import app.irprgrmr.mat.feature.crypto.data.local.entitiy.CoinEntity

@Database(
    entities = [CoinEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CoinDatabase : RoomDatabase() {
    //region Companion
    companion object {
        const val NAME = "CoinDatabase.db"
    }
    //endregion Companion

    //region Variables
    abstract val coinDao: CoinDao
    //endregion Variables
}