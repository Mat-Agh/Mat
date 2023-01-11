package app.irprgrmr.mat.feature.crypto.domain.repository

import app.irprgrmr.mat.common.Resource
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel
import kotlinx.coroutines.flow.Flow

interface CoinRepositoryInterface {
    suspend fun getCoins(fetchFromRemote: Boolean, query: String?): Flow<Resource<List<CoinModel>>>
}