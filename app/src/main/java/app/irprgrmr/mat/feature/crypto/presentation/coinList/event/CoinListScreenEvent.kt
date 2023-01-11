package app.irprgrmr.mat.feature.crypto.presentation.coinList.event

sealed class CoinListScreenEvent {
    object Refresh : CoinListScreenEvent()
    data class OnSearchQueryChange(val query: String) : CoinListScreenEvent()
}