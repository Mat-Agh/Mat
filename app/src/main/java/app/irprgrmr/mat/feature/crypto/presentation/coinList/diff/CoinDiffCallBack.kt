package app.irprgrmr.mat.feature.crypto.presentation.coinList.diff

import androidx.recyclerview.widget.DiffUtil
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel

class CoinDiffCallBack : DiffUtil.ItemCallback<Pair<CoinModel?, CoinModel?>>() {
    override fun areItemsTheSame(
        oldItem: Pair<CoinModel?, CoinModel?>,
        newItem: Pair<CoinModel?, CoinModel?>
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: Pair<CoinModel?, CoinModel?>,
        newItem: Pair<CoinModel?, CoinModel?>
    ): Boolean = oldItem.first == newItem.first && oldItem.second == newItem.second
}