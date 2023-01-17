package app.irprgrmr.mat.feature.coroutine.presentation.coroutine.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.irprgrmr.mat.feature.coroutine.presentation.coroutine.state.CoroutineScreenState
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutineViewModel : ViewModel() {
    //region Companion
    companion object {
        private const val TAG = "CoroutineScreen"
    }
    //endregion Companion

    //region Variables
    var state by mutableStateOf(CoroutineScreenState())
    //endregion

    //region initialization
    init {
        doTheThing()
    }
    //endregion initialization

    //region Logic
    private fun doTheThing() {
        val job = viewModelScope.launch(Dispatchers.IO) {
            val time = measureTimeMillis {
                val answer1 = async {
                    networkCall1()
                }
                val answer2 = async {
                    networkCall2()
                }

                runBlocking {

                }
                Log.d(TAG, "Answer1 is ${answer1.await()}")
                Log.d(TAG, "Answer2 is ${answer2.await()}")
            }
            Log.d(TAG, "Request took $time ms.")
        }
    }

    private fun fib(n: Int): Long {
        return when (n) {
            0 -> 0
            1 -> 1
            else -> fib(n - 1) + fib(n - 2)
        }
    }

    private suspend fun networkCall1(): String {
        delay(3000L)
        return "Answer is 1"
    }

    private suspend fun networkCall2(): String {
        delay(3000L)
        return "Answer is 2"
    }
    //endregion Logic
}