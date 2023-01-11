package app.irprgrmr.mat.feature.crypto.data.repository

import app.irprgrmr.mat.common.Resource
import app.irprgrmr.mat.common.constants.ExceptionMessage
import app.irprgrmr.mat.common.getEmpty
import app.irprgrmr.mat.feature.crypto.data.local.database.CoinDatabase
import app.irprgrmr.mat.feature.crypto.data.mapper.toCoinEntity
import app.irprgrmr.mat.feature.crypto.data.mapper.toCoinModel
import app.irprgrmr.mat.feature.crypto.data.remote.ServiceApi
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel
import app.irprgrmr.mat.feature.crypto.domain.repository.CoinRepositoryInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoRepository @Inject constructor(
    private val api: ServiceApi,
    private val db: CoinDatabase
) : CoinRepositoryInterface {
    //region Variables
    private val coinDao = db.coinDao
    //endregion

    //region Override Methods
    override suspend fun getCoins(
        fetchFromRemote: Boolean,
        query: String?
    ): Flow<Resource<List<CoinModel>>> = flow {
        emit(Resource.Loading(true))
        val coins = coinDao.getCoins()
        emit(Resource.Success(coins.map { it.toCoinModel() }))

        val isDatabaseEmpty = coins.isEmpty() && !query.isNullOrBlank()
        val shouldLoadFromCash = !isDatabaseEmpty && !fetchFromRemote
        if (shouldLoadFromCash) {
            emit(Resource.Loading(false))
            return@flow
        }

        val cryptoData = try {
            api.getCryptoData(if (query.isNullOrEmpty()) String.getEmpty() else query)
        } catch (e: IOException) {
            emit(Resource.Error(ExceptionMessage.IO_EXCEPTION_MESSAGE))
            null
        } catch (e: HttpException) {
            emit(Resource.Error(ExceptionMessage.HTTP_EXCEPTION_MESSAGE))
            null
        }

        cryptoData?.coins?.let { coinList ->
            coinDao.clearCoins()
            coinDao.insertCoins(coinList.map { it.toCoinEntity() })
            emit(
                Resource.Success(
                    data = coinDao
                        .getCoins()
                        .map {
                            it.toCoinModel()
                        }
                )
            )

            emit(
                Resource.Loading(false)
            )
        }
    }
    //endregion
}