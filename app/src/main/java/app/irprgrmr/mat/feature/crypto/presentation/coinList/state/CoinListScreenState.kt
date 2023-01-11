package app.irprgrmr.mat.feature.crypto.presentation.coinList.state

import app.irprgrmr.mat.common.getEmpty
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel

data class CoinListScreenState(
    val coins: List<CoinModel> = listOf(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = String.getEmpty()
)