package app.irprgrmr.mat.feature.crypto.data.remote.dto

import com.squareup.moshi.Json

data class ExchangeDto(
    @field:Json(name = "id") val id: String? = null,
    @field:Json(name = "name") val name: String? = null,
    @field:Json(name = "market_type") val marketType: String? = null,
    @field:Json(name = "thumb") val thumb: String? = null,
    @field:Json(name = "large") val large: String? = null
)
