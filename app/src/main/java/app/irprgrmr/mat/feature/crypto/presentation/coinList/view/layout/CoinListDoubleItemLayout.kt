package app.irprgrmr.mat.feature.crypto.presentation.coinList.view.layout

import android.content.Context
import android.view.ViewGroup

//region Constants
const val PARENT_START_RESOURCE_ID = 300000
const val PARENT_END_RESOURCE_ID = 400000
//endregion Constants

//region Layout
fun getCoinListDoubleItemLayout(
    context: Context,
    parentId: Int
): ViewGroup {
    val cardView = getCardView(
        context = context,
        parentId = parentId,
        isSingleItem = false
    )

    val parent = getConstraintLayoutParent(
        context = context,
        parentId = cardView.id,
        currentId = PARENT_RESOURCE_ID,
        neighborsCount = 0
    )

    val parentStart = getConstraintLayoutParent(
        context = context,
        parentId = parent.id,
        currentId = PARENT_START_RESOURCE_ID,
        neighborsCount = 1
    )

    val imageView1 = getImageView(
        context = context,
        parentId = parentStart.id,
        currentId = IMAGE_VIEW_RESOURCE_ID,
        neighborsCount = 1
    )

    val textView1 = getTextView(
        context = context,
        parentId = parentStart.id,
        currentId = TEXT_VIEW_RESOURCE_ID
    )

    parentStart.apply {
        addView(
            imageView1
        )
        addView(
            textView1
        )
    }

    val parentEnd = getConstraintLayoutParent(
        context = context,
        parentId = parent.id,
        currentId = PARENT_END_RESOURCE_ID,
        neighborsCount = 1
    )

    val imageView2 = getImageView(
        context = context,
        parentId = parentEnd.id,
        currentId = IMAGE_VIEW_RESOURCE_ID,
        neighborsCount = 1
    )

    val textView2 = getTextView(
        context = context,
        parentId = parentEnd.id,
        currentId = TEXT_VIEW_RESOURCE_ID
    )

    parentEnd.apply {
        addView(
            imageView2
        )
        addView(
            textView2
        )
    }

    parent.apply {
        addView(
            parentStart
        )
        addView(
            parentEnd
        )
    }

    cardView.addView(
        parent
    )

    return cardView
}
//endregion Layout