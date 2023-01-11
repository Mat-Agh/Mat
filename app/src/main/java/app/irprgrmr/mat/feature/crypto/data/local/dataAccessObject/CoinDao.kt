package app.irprgrmr.mat.feature.crypto.data.local.dataAccessObject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.irprgrmr.mat.feature.crypto.data.local.entitiy.CoinEntity

@Dao
interface CoinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoins(
        coins: List<CoinEntity>
    )

    @Query("DELETE FROM coinentity")
    suspend fun clearCoins()

    @Query("SELECT * FROM coinentity")
    suspend fun getCoins(): List<CoinEntity>
}