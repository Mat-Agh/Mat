package app.irprgrmr.mat.feature.crypto.presentation.coinList.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.irprgrmr.mat.R
import app.irprgrmr.mat.feature.crypto.presentation.coinList.event.CoinListScreenEvent
import app.irprgrmr.mat.feature.crypto.presentation.coinList.screen.item.CoinListFirstItemScreen
import app.irprgrmr.mat.feature.crypto.presentation.coinList.screen.item.CoinListItemScreen
import app.irprgrmr.mat.feature.crypto.presentation.coinList.viewModel.CryptoViewModel

@Composable
@ExperimentalMaterial3Api
fun CoinListScreen(
    viewModel: CryptoViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(CoinListScreenEvent.OnSearchQueryChange(it))
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(id = R.string.search_field_empty))
            },
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors()
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(state.coins) { index, coin ->
                viewModel.state.isLoading
                if (index > 0) {
                    CoinListItemScreen(
                        coinModel = coin,
                        modifier = modifier
                    )
                } else CoinListFirstItemScreen(
                    coinModel = coin,
                    modifier = modifier
                )

                if (index < state.coins.size) {
                    Divider(
                        modifier = Modifier.padding(
                            horizontal = 16.dp
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CoinListScreenPreview() {
    CoinListScreen(
        viewModel = hiltViewModel(),
        modifier = Modifier
    )
}