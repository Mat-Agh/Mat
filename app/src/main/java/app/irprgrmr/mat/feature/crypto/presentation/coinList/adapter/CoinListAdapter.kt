package app.irprgrmr.mat.feature.crypto.presentation.coinList.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel
import app.irprgrmr.mat.feature.crypto.presentation.coinList.diff.CoinDiffCallBack
import app.irprgrmr.mat.feature.crypto.presentation.coinList.view.layout.getCoinListDoubleItemLayout
import app.irprgrmr.mat.feature.crypto.presentation.coinList.view.layout.getCoinListSingleItemLayout
import app.irprgrmr.mat.feature.crypto.presentation.coinList.viewHolder.CoinListViewHolder

class CoinListAdapter : ListAdapter<Pair<CoinModel?, CoinModel?>, CoinListViewHolder>(CoinDiffCallBack()) {
    //region companion
    companion object {
        private const val VIEW_TYPE_SINGLE = 0
        private const val VIEW_TYPE_DOUBLE = 1
    }

    //endregion companion
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoinListViewHolder =
            if (viewType == VIEW_TYPE_SINGLE) CoinListViewHolder(
                getCoinListSingleItemLayout(
                    context = parent.context,
                    parentId = parent.id
                )
            ) else CoinListViewHolder(
                getCoinListDoubleItemLayout(
                    context = parent.context,
                    parentId = parent.id
                )
            )


    override fun onBindViewHolder(
        holder: CoinListViewHolder,
        position: Int
    ) = holder.bind(
        getItem(position)
    )

    override fun getItemViewType(
        position: Int
    ): Int = if (getItem(position).second == null)
        VIEW_TYPE_SINGLE
    else VIEW_TYPE_DOUBLE

    fun submitData(coins: List<CoinModel>?) {
        coins ?: return

        val coinsArranged: MutableList<Pair<CoinModel?, CoinModel?>> = mutableListOf()

        var indexOfCoinsArrangedList = 0
        var indexOfNextCoinToAdd = 0

        while (indexOfNextCoinToAdd < (coins.size - 1)) {
            if (indexOfCoinsArrangedList % 2 == 0) {
                coinsArranged.add(
                    Pair(
                        coins[indexOfNextCoinToAdd],
                        null
                    )
                )

                indexOfNextCoinToAdd++
            } else {
                coinsArranged.add(
                    Pair(
                        coins[indexOfNextCoinToAdd],
                        coins[indexOfNextCoinToAdd + 1]
                    )
                )

                indexOfNextCoinToAdd += 2
            }

            indexOfCoinsArrangedList++
        }

        submitList(coinsArranged)
    }
}