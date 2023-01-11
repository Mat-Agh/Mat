package app.irprgrmr.mat.feature.crypto.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CoinEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val mId: String? = null,
    val name: String? = null,
    val apiSymbol: String? = null,
    val symbol: String? = null,
    val marketCapRank: Int? = null,
    val thumb: String? = null,
    val large: String? = null
)