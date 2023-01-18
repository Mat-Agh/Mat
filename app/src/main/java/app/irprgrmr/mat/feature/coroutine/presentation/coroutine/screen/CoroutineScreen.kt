package app.irprgrmr.mat.feature.coroutine.presentation.coroutine.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import app.irprgrmr.mat.common.getEmpty
import app.irprgrmr.mat.feature.coroutine.presentation.coroutine.viewModel.CoroutineViewModel

@Composable
fun CoroutineScreen(
    modifier: Modifier,
    viewModel: CoroutineViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = state.text ?: String.getEmpty(),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
    }
}