package app.irprgrmr.mat.feature.crypto.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CryptoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val mId: String? = null,
    val coins: List<CoinEntity> = listOf(),
    val exchanges: List<ExchangeEntity> = listOf(),
    val icons: List<String> = listOf(),
    val categories: List<CategoryEntity> = listOf(),
    val nfts: List<NFTEntity> = listOf()
)