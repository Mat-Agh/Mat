package app.irprgrmr.mat.feature.crypto.presentation.coinList.screen.item

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.irprgrmr.mat.common.getEmpty
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel
import coil.compose.AsyncImage

@Composable
fun CoinListItemScreen(
    coinModel: CoinModel,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Profile image
            AsyncImage(
                model = coinModel.thumb,
                contentDescription = coinModel.symbol,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(56.dp),
                placeholder = ColorPainter(Color.Magenta)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = coinModel.name ?: String.getEmpty(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun CoinListItemScreenPreview() {
    CoinListItemScreen(
        coinModel = CoinModel(),
        modifier = Modifier
    )
}