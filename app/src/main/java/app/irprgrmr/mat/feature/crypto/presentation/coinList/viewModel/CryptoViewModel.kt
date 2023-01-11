package app.irprgrmr.mat.feature.crypto.presentation.coinList.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.irprgrmr.mat.common.Resource
import app.irprgrmr.mat.feature.crypto.domain.repository.CoinRepositoryInterface
import app.irprgrmr.mat.feature.crypto.presentation.coinList.event.CoinListScreenEvent
import app.irprgrmr.mat.feature.crypto.presentation.coinList.state.CoinListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val repository: CoinRepositoryInterface
) : ViewModel() {
    //region Variables
    var state by mutableStateOf(CoinListScreenState())
    private var searchJob: Job? = null
    //endregion

    //region initialization
    init {
        viewModelScope.launch {
            getCoinList()
        }
    }
    //endregion

    //region Events
    fun onEvent(event: CoinListScreenEvent) {
        when (event) {
            is CoinListScreenEvent.Refresh -> {
                getCoinList(fetchFromRemote = true)
            }
            is CoinListScreenEvent.OnSearchQueryChange -> {
                state = state.copy(searchQuery = event.query)

                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(1000L)
                    getCoinList()
                }
            }
        }
    }
    //endregion

    //region Logic
    private fun getCoinList(
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = true
    ) {
        viewModelScope.launch {
            repository.getCoins(fetchFromRemote, query)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { coins ->
                                state = state.copy(coins = coins)
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
    //endregion
}