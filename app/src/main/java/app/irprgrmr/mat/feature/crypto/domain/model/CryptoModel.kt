package app.irprgrmr.mat.feature.crypto.domain.model

data class CryptoModel(
    var coins: List<CoinModel>? = null,
    var exchanges: List<ExchangeModel>? = null,
    var icons: List<String>? = null,
    var categories: List<CategoryModel>? = null,
    var nfts: List<NFTModel>? = null
)
