package app.irprgrmr.mat.feature.crypto.data.remote.dto

import com.squareup.moshi.Json

data class CryptoDto(
    @field:Json(name = "coins") val coins: List<CoinDto>? = null,
    @field:Json(name = "exchanges") val exchanges: List<ExchangeDto>? = null,
    @field:Json(name = "icos") val icons: List<String>? = null,
    @field:Json(name = "categories") val categories: List<CategoryDto>? = null,
    @field:Json(name = "nfts") val nfts: List<NFTDto>? = null
)
