package app.irprgrmr.mat.feature.crypto.data.remote.dto

import com.squareup.moshi.Json

data class NFTDto(
    @field:Json(name = "id") val id: String? = null,
    @field:Json(name = "name") val name: String? = null
)
