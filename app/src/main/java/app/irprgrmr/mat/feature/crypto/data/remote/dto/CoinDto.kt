package app.irprgrmr.mat.feature.crypto.data.remote.dto

import com.squareup.moshi.Json

data class CoinDto(
    @field:Json(name = "id") val id: String? = null,
    @field:Json(name = "name") val name: String? = null,
    @field:Json(name = "api_symbol") val apiSymbol: String? = null,
    @field:Json(name = "symbol") val symbol: String? = null,
    @field:Json(name = "market_cap_rank") val marketCapRank: Int? = null,
    @field:Json(name = "thumb") val thumb: String? = null,
    @field:Json(name = "large") val large: String? = null
)
