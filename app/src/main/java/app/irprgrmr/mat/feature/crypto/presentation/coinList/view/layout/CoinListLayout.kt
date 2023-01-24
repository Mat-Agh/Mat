package app.irprgrmr.mat.feature.crypto.presentation.coinList.view.layout

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.irprgrmr.mat.R
import app.irprgrmr.mat.feature.crypto.presentation.coinList.adapter.CoinListAdapter
import app.irprgrmr.mat.feature.crypto.presentation.coinList.event.CoinListScreenEvent
import app.irprgrmr.mat.feature.crypto.presentation.coinList.viewModel.CryptoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//region constants
const val PARENT_RESOURCE_ID = 100001
const val RECYCLER_VIEW_RESOURCE_ID = 100011
const val EDIT_TEXT_RESOURCE_ID = 100111
//endregion

//region Layout
fun getCoinListFragmentLayout(
	context: Context?,
	adapter: CoinListAdapter,
	viewModel: CryptoViewModel,
	lifecycleScope: LifecycleCoroutineScope
): View? {
	context ?: return null

	val parent = getParent(
		context = context
	)

	val editText = getSearchEditText(
		context = context,
		parentId = parent.id,
		viewModel = viewModel,
		lifecycleScope = lifecycleScope
	)

	val recyclerView = getRecyclerView(
		context = context,
		parentId = parent.id,
		adapter = adapter
	)

	parent.apply {
		addView(
			editText
		)
		addView(
			recyclerView
		)
	}

	return parent
}
//endregion Layout

//region Private Methods
private fun getParent(
	context: Context
): ConstraintLayout {
	val parentParams: ConstraintLayout.LayoutParams = ConstraintLayout.LayoutParams(
		LayoutParams.MATCH_PARENT,
		LayoutParams.MATCH_PARENT
	)

	val parent: ConstraintLayout = ConstraintLayout(context).apply {
		id = PARENT_RESOURCE_ID
		layoutParams = parentParams
		setBackgroundColor(
			Color.BLACK
		)
	}

	return parent
}

private fun getSearchEditText(
	context: Context,
	parentId: Int,
	viewModel: CryptoViewModel,
	lifecycleScope: LifecycleCoroutineScope
): EditText {
	val width = context.resources.displayMetrics.widthPixels
	val density = context.resources.displayMetrics.density

	val layoutParams = ConstraintLayout.LayoutParams(
		LayoutParams.MATCH_PARENT,
		(width * 0.16f).toInt()
	)

	layoutParams.apply {
		topToTop = parentId
		endToEnd = parentId
		startToStart = parentId
		bottomToTop = RECYCLER_VIEW_RESOURCE_ID
		marginStart = (13 * density).toInt()
		marginEnd = (13 * density).toInt()
		topMargin = (20 * density).toInt()
	}

	val editText = EditText(context).apply {
		id = EDIT_TEXT_RESOURCE_ID
		setPadding(
			(15 * density).toInt(),
			(5 * density).toInt(),
			(15 * density).toInt(),
			(5 * density).toInt()
		)
		setLayoutParams(
			layoutParams
		)
		textSize = TypedValue.applyDimension(
			TypedValue.COMPLEX_UNIT_SP,
			10f,
			context.resources.displayMetrics
		)
		setTextColor(
			Color.WHITE
		)
		hint = "Search..."
		setHintTextColor(
			Color.GRAY
		)
		background = ContextCompat.getDrawable(
			context,
			R.drawable.rounded_corner_rectangle
		)
		isSingleLine = true
		maxLines = 1

	}

	editText.doOnTextChanged { text, _, _, _ ->
		lifecycleScope.launch(Dispatchers.Unconfined) {
			viewModel.onEvent(
				CoinListScreenEvent.OnSearchQueryChange(
					text.toString()
				)
			)
		}
	}

	return editText
}

private fun getRecyclerView(
	context: Context,
	parentId: Int,
	adapter: CoinListAdapter
): RecyclerView {
	val density = context.resources.displayMetrics.density

	val layoutParams = ConstraintLayout.LayoutParams(
		LayoutParams.MATCH_PARENT,
		0
	)

	layoutParams.apply {
		topToBottom = EDIT_TEXT_RESOURCE_ID
		bottomToBottom = parentId
		startToStart = parentId
		endToEnd = parentId
		topMargin = (5 * density).toInt()
		bottomMargin = (10 * density).toInt()
		marginStart = (10 * density).toInt()
		marginEnd = (10 * density).toInt()
	}

	val layoutManager = LinearLayoutManager(
		context,
		RecyclerView.VERTICAL,
		false
	)

	val recyclerView = RecyclerView(context).apply {
		id = RECYCLER_VIEW_RESOURCE_ID
		setAdapter(adapter)
		setLayoutParams(layoutParams)
		setLayoutManager(layoutManager)
	}

	return recyclerView
}
//endregion Private