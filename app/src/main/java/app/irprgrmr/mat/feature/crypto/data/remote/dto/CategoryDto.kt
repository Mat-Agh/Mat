package app.irprgrmr.mat.feature.crypto.data.remote.dto

import com.squareup.moshi.Json

data class CategoryDto(
    @field:Json(name = "id") val id: Int? = null,
    @field:Json(name = "name") val name: String? = null
)
