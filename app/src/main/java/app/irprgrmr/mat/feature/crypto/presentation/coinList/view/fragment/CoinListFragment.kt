package app.irprgrmr.mat.feature.crypto.presentation.coinList.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import app.irprgrmr.mat.feature.crypto.presentation.coinList.adapter.CoinListAdapter
import app.irprgrmr.mat.feature.crypto.presentation.coinList.view.layout.getCoinListFragmentLayout
import app.irprgrmr.mat.feature.crypto.presentation.coinList.viewModel.CryptoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinListFragment : Fragment() {
	//region Variables
	private val viewModel by viewModels<CryptoViewModel>()
	private var layout: View? = null
	private var adapter: CoinListAdapter = CoinListAdapter()
	//endregion Variables

	//region Companion
	companion object {
		fun newInstance(): CoinListFragment = CoinListFragment()
	}
	//endregion

	//region Override Methods
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		layout = getCoinListFragmentLayout(
			context = context,
			adapter = adapter,
			viewModel = viewModel,
			lifecycleScope = lifecycleScope
		)

		return layout
	}

	override fun onViewCreated(
		view: View,
		savedInstanceState: Bundle?
	) {
		super.onViewCreated(
			view,
			savedInstanceState
		)

		lifecycleScope.launch(Dispatchers.IO) {
			viewModel.state.flowWithLifecycle(
				lifecycle = lifecycle
			)
				.collect {
					if (!it.isLoading) {
						adapter.submitData(it.coins)
					}
				}
		}
	}
	//endregion Override Methods

	//region Private Methods

	//endregion Private Methods
}