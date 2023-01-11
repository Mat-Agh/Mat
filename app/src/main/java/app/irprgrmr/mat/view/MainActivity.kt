package app.irprgrmr.mat.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import app.irprgrmr.mat.feature.crypto.presentation.coinList.screen.CoinListScreen
import app.irprgrmr.mat.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //region Variables
    lateinit var navController: NavHostController
    //endregion

    //region Override Methods
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        setContent {
            AppTheme {
                CoinListScreen(
                    modifier = Modifier
                        .fillMaxSize(1f)
                )
            }
        }
    }
    //endregion Override Methods
}