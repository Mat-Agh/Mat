package app.irprgrmr.mat.view

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import app.irprgrmr.mat.feature.crypto.presentation.coinList.view.fragment.CoinListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    //region Variables

    //endregion Variables

    //region Companion
    companion object {
        private const val ACTIVITY_PARENT_RESOURCE_ID = 10000
    }
    //endregion Companion

    //region Override Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val frame = FrameLayout(this)
        frame.id = ACTIVITY_PARENT_RESOURCE_ID
        setContentView(
            frame,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        val coinListFragment: Fragment = CoinListFragment.newInstance()
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            ACTIVITY_PARENT_RESOURCE_ID,
            coinListFragment
        )
                .commit()
    }
    //endregion Override Methods
}