package app.irprgrmr.mat.feature.crypto.domain.model

data class CoinModel(
    var id: String? = null,
    var name: String? = null,
    var apiSymbol: String? = null,
    var symbol: String? = null,
    var marketCapRank: Int? = null,
    var thumb: String? = null,
    var large: String? = null
)