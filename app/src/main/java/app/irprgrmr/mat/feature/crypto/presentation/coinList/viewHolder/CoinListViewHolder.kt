package app.irprgrmr.mat.feature.crypto.presentation.coinList.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import app.irprgrmr.mat.R
import app.irprgrmr.mat.common.getEmpty
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel
import app.irprgrmr.mat.feature.crypto.presentation.coinList.view.layout.*
import coil.load
import coil.transform.CircleCropTransformation
import okhttp3.HttpUrl.Companion.toHttpUrl

class CoinListViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    fun bind(
        coinSet: Pair<CoinModel?, CoinModel?>,
    ) {
        val isSingleItem = coinSet.second == null

        if (isSingleItem) {
            val cardView = itemView.rootView.findViewById<CardView>(CARD_VIEW_RESOURCE_ID)
            val parent = cardView.findViewById<ConstraintLayout>(PARENT_RESOURCE_ID)
            val imageView = parent.findViewById<ImageView>(IMAGE_VIEW_RESOURCE_ID)
            val textView = parent.findViewById<TextView>(TEXT_VIEW_RESOURCE_ID)

            imageView.load(
                coinSet.first?.large?.toHttpUrl()
            ) {
                crossfade(
                    true
                )

                transformations(
                    CircleCropTransformation()
                )

                placeholder(
                    R.drawable.circle_image_view_place_holder
                )
            }

            textView.text = coinSet.first?.name ?: String.getEmpty()
        } else {
            val cardView = itemView.rootView.findViewById<CardView>(CARD_VIEW_RESOURCE_ID)
            val parent = cardView.findViewById<ConstraintLayout>(PARENT_RESOURCE_ID)
            val parentStart = parent.findViewById<ConstraintLayout>(PARENT_START_RESOURCE_ID)
            val parentEnd = parent.findViewById<ConstraintLayout>(PARENT_END_RESOURCE_ID)
            val imageView1 = parentStart.findViewById<ImageView>(IMAGE_VIEW_RESOURCE_ID)
            val textView1 = parentStart.findViewById<TextView>(TEXT_VIEW_RESOURCE_ID)
            val imageView2 = parentEnd.findViewById<ImageView>(IMAGE_VIEW_RESOURCE_ID)
            val textView2 = parentEnd.findViewById<TextView>(TEXT_VIEW_RESOURCE_ID)

            imageView1.load(
                coinSet.first?.large?.toHttpUrl()
            ) {
                crossfade(
                    true
                )

                transformations(
                    CircleCropTransformation()
                )

                placeholder(
                    R.drawable.circle_image_view_place_holder
                )
            }

            imageView2.load(
                coinSet.second?.large?.toHttpUrl()
            ) {
                crossfade(
                    true
                )

                transformations(
                    CircleCropTransformation()
                )

                placeholder(
                    R.drawable.circle_image_view_place_holder
                )
            }

            textView1.text = coinSet.first?.name ?: String.getEmpty()

            textView2.text = coinSet.second?.name ?: String.getEmpty()
        }
    }
}