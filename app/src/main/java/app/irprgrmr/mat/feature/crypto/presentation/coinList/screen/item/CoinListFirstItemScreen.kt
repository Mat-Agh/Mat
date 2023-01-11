package app.irprgrmr.mat.feature.crypto.presentation.coinList.screen.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.irprgrmr.mat.common.getEmpty
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun CoinListFirstItemScreen(
    coinModel: CoinModel,
    //    onItemClick: (CoinModel) -> Unit,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(),
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = coinModel.large,
            ),
            contentDescription = coinModel.name,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(1f / 1f)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = coinModel.name ?: String.getEmpty(),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoinListFirstItemScreenPreview() {
    CoinListFirstItemScreen(
        coinModel = CoinModel(),
        modifier = Modifier
    )
}