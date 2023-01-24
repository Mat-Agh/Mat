package app.irprgrmr.mat.feature.crypto.presentation.coinList.view.layout

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout

//region constants
const val CARD_VIEW_RESOURCE_ID = 200022
const val IMAGE_VIEW_RESOURCE_ID = 200222
const val TEXT_VIEW_RESOURCE_ID = 202222
//endregion

//region Layout
fun getCoinListSingleItemLayout(
    context: Context,
    parentId: Int
): ViewGroup {
    val parent = getConstraintLayoutParent(
        context = context,
        parentId = parentId,
        currentId = PARENT_RESOURCE_ID,
        neighborsCount = 0
    )

    val imageView = getImageView(
        context = context,
        parentId = parent.id,
        currentId = IMAGE_VIEW_RESOURCE_ID,
        neighborsCount = 0
    )

    val textView = getTextView(
        context,
        parentId = parent.id,
        currentId = TEXT_VIEW_RESOURCE_ID
    )

    parent.apply {
        addView(
            imageView
        )
        addView(
            textView
        )
    }

    val cardView = getCardView(
        context = context,
        parentId = parentId,
        isSingleItem = true
    )

    cardView.apply {
        id = CARD_VIEW_RESOURCE_ID
        addView(
            parent
        )
    }

    return cardView
}
//endregion Layout

//region Private
fun getCardView(
    context: Context,
    parentId: Int,
    isSingleItem: Boolean
): CardView {
    val width = context.resources.displayMetrics.widthPixels
    val density = context.resources.displayMetrics.density

    val layoutParams = ConstraintLayout.LayoutParams(
        ConstraintLayout.LayoutParams.MATCH_PARENT,
        if (isSingleItem) (width - 50) else ((width - 50) / 2)
    )

    layoutParams.apply {
        startToStart = parentId
        endToEnd = parentId
        topMargin = (5 * density).toInt()
        bottomMargin = (10 * density).toInt()
        marginStart = (5 * density).toInt()
        marginEnd = (5 * density).toInt()
    }

    val cardView = CardView(context).apply {
        id = CARD_VIEW_RESOURCE_ID
        setLayoutParams(layoutParams)
        cardElevation = (5 * density)
        elevation = (5 * density)
        setCardBackgroundColor(
            Color.RED
        )
        radius = 10 * density
    }

    return cardView
}

fun getConstraintLayoutParent(
    context: Context,
    parentId: Int,
    currentId: Int,
    neighborsCount: Int
): ConstraintLayout {
    val width = context.resources.displayMetrics.widthPixels

    val params = ConstraintLayout.LayoutParams(
        ((width - 50) / (neighborsCount + 1)),
        ConstraintLayout.LayoutParams.MATCH_PARENT
    )

    params.apply {
        if (currentId == PARENT_START_RESOURCE_ID) {
            startToStart = parentId
            endToStart = PARENT_END_RESOURCE_ID
            topToTop = parentId
            bottomToBottom = parentId
        } else if (currentId == PARENT_END_RESOURCE_ID) {
            startToEnd = PARENT_START_RESOURCE_ID
            endToEnd = parentId
            topToTop = parentId
            bottomToBottom = parentId
        }
    }

    val parent = ConstraintLayout(context).apply {
        id = currentId
        layoutParams = params
    }

    return parent
}

fun getImageView(
    context: Context,
    parentId: Int,
    currentId: Int,
    neighborsCount: Int
): ImageView {
    val width = context.resources.displayMetrics.widthPixels

    val layoutParams = ConstraintLayout.LayoutParams(
        (width / ((neighborsCount + 1) * 2)),
        (width / ((neighborsCount + 1) * 2))
    )

    layoutParams.apply {
        topToTop = parentId
        startToStart = parentId
        endToEnd = parentId
        bottomToTop = TEXT_VIEW_RESOURCE_ID
    }

    val imageView = ImageView(context).apply {
        id = currentId
        setLayoutParams(layoutParams)
    }

    return imageView
}

fun getTextView(
    context: Context,
    parentId: Int,
    currentId: Int
): TextView {
    val width = context.resources.displayMetrics.widthPixels

    val layoutParams = ConstraintLayout.LayoutParams(
        (width / 0.8f).toInt(),
        ConstraintLayout.LayoutParams.WRAP_CONTENT
    )

    layoutParams.apply {
        topToBottom = IMAGE_VIEW_RESOURCE_ID
        bottomToBottom = parentId
        startToStart = parentId
        endToEnd = parentId
    }

    val textView = TextView(context).apply {
        id = currentId
        setLayoutParams(layoutParams)
        textSize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            8f,
            context.resources.displayMetrics
        )
        setTextColor(Color.WHITE)
        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
    }

    return textView
}
//endregion Private