package app.irprgrmr.mat.feature.crypto.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExchangeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val mId: String? = null,
    val name: String? = null,
    val marketType: String? = null,
    val thumb: String? = null,
    val large: String? = null
)