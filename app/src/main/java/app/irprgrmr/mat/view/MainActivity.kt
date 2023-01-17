package app.irprgrmr.mat.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import app.irprgrmr.mat.feature.coroutine.presentation.coroutine.CoroutineScreen
import app.irprgrmr.mat.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //region Variables
    //lateinit var navController: NavHostController

    //endregion

    //region Override Methods
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        setContent {
            AppTheme {
//                CoinListScreen(
//                    modifier = Modifier
//                        .fillMaxSize(1f)
//                )

                CoroutineScreen(
                    modifier = Modifier
                        .fillMaxSize(1f)
                )
            }
        }
    }
    //endregion Override Methods
}