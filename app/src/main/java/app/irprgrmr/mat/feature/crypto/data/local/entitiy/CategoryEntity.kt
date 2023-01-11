package app.irprgrmr.mat.feature.crypto.data.local.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val mId: Int? = null,
    val name: String? = null
)