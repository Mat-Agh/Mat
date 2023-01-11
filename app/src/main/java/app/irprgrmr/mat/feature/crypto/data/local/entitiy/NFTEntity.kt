package app.irprgrmr.mat.feature.crypto.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NFTEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val mId: String? = null,
    var name: String? = null
)