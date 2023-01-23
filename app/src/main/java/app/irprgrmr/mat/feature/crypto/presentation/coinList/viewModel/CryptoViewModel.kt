package app.irprgrmr.mat.feature.crypto.presentation.coinList.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.irprgrmr.mat.common.Resource
import app.irprgrmr.mat.feature.crypto.domain.repository.CoinRepositoryInterface
import app.irprgrmr.mat.feature.crypto.presentation.coinList.event.CoinListScreenEvent
import app.irprgrmr.mat.feature.crypto.presentation.coinList.state.CoinListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val repository: CoinRepositoryInterface
) : ViewModel() {
    //region Variables
    private val _state = MutableStateFlow(CoinListScreenState())
    val state = _state.asStateFlow()
    private var searchJob: Job? = null
    //endregion

    //region initialization
    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCoinList()
        }
    }
    //endregion

    //region Events
//    suspend fun onEvent(event: CoinListScreenEvent) {
//        coroutineScope {
//            launch(Dispatchers.IO) {
//                when (event) {
//                    is CoinListScreenEvent.Refresh -> {
//                        getCoinList(fetchFromRemote = true)
//                    }
//                    is CoinListScreenEvent.OnSearchQueryChange -> {
//                        _state.value = _state.value.copy(searchQuery = event.query)
//
//                        if (!state.value.isLoading && searchJob?.isActive == false) {
//                            searchJob?.cancel()
//                            searchJob = viewModelScope.launch {
//                                delay(1000L)
//                                getCoinList()
//                            }
//                        } else if (state.value.isLoading && searchJob?.isActive == true) {
//                            searchJob?.cancel()
//                        }
//                    }
//                }
//            }
//        }
//    }

    fun onEvent(event: CoinListScreenEvent) {
        when (event) {
            is CoinListScreenEvent.Refresh             -> {
                getCoinList(fetchFromRemote = true)
            }
            is CoinListScreenEvent.OnSearchQueryChange -> {
                _state.value = _state.value.copy(searchQuery = event.query)

                if (!state.value.isLoading && searchJob?.isActive == false) {
                    searchJob?.cancel()
                    searchJob = viewModelScope.launch {
                        delay(1000L)
                        getCoinList()
                    }
                } else if (state.value.isLoading && searchJob?.isActive == true) {
                    searchJob?.cancel()
                }
            }
        }
    }
    //endregion

    //region Logic
    private fun getCoinList(
        query: String = state.value.searchQuery.lowercase(),
        fetchFromRemote: Boolean = true
    ) {
        if (state.value.isLoading) return

        viewModelScope.launch(Dispatchers.IO) {
            repository.getCoins(
                fetchFromRemote,
                query
            )
                    .collect { result ->
                        when (result) {
                            is Resource.Success -> {
                                result.data?.let { coins ->
                                    _state.value = _state.value.copy(coins = coins)
                                }
                            }
                            is Resource.Error   -> {
                                _state.value = _state.value.copy(isLoading = false)
                            }
                            is Resource.Loading -> {
                                _state.value = _state.value.copy(isLoading = result.isLoading)
                            }
                        }
                    }
        }
    }
    //endregion
}