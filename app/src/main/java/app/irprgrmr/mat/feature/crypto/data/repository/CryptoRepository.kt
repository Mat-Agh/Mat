package app.irprgrmr.mat.feature.crypto.data.repository

import app.irprgrmr.mat.common.Resource
import app.irprgrmr.mat.common.constants.ExceptionMessage
import app.irprgrmr.mat.feature.crypto.data.local.database.CoinDatabase
import app.irprgrmr.mat.feature.crypto.data.mapper.toCoinEntity
import app.irprgrmr.mat.feature.crypto.data.mapper.toCoinModel
import app.irprgrmr.mat.feature.crypto.data.remote.ServiceApi
import app.irprgrmr.mat.feature.crypto.data.remote.dto.CoinDto
import app.irprgrmr.mat.feature.crypto.data.remote.dto.CryptoDto
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel
import app.irprgrmr.mat.feature.crypto.domain.repository.CoinRepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoRepository @Inject constructor(
    private val api: ServiceApi,
    db: CoinDatabase
) : CoinRepositoryInterface {
    //region Variables
    private val coinDao = db.coinDao
    //endregion

    //region Override Methods
    override suspend fun getCoins(
        fetchFromRemote: Boolean,
        query: String?
    ): Flow<Resource<List<CoinModel>>> = flow {
        emit(Resource.Loading(isLoading = true))

        var coinsFromLocal = listOf<CoinModel>()

        if (fetchFromRemote) {
            val cryptoData: CryptoDto? = try {
                val response = api.getCryptoData(query)
                if (response.isSuccessful) response.body()
                else {
                    emit(Resource.Error(response.message()))
                    null
                }
            } catch (e: IOException) {
                emit(Resource.Error(ExceptionMessage.IO_EXCEPTION_MESSAGE))
                null
            } catch (e: HttpException) {
                emit(Resource.Error(ExceptionMessage.HTTP_EXCEPTION_MESSAGE))
                null
            }

            val saveJob = coroutineScope {
                launch(Dispatchers.IO) {
                    cryptoData?.let { saveToLocal(it.coins) }
                }
            }

            saveJob.join()


            val readJob = coroutineScope {
                launch(Dispatchers.IO) {
                    coinsFromLocal = getCoinModelList()
                }
            }

            readJob.join()

            emit(
                Resource.Success(
                    data = coinsFromLocal
                )
            )

            emit(
                Resource.Loading(false)
            )
        } else {
            val readJob = coroutineScope {
                launch(Dispatchers.IO) {
                    coinsFromLocal = getCoinModelList()
                }
            }

            readJob.join()

            emit(
                Resource.Success(
                    data = coinsFromLocal
                )
            )

            emit(Resource.Loading(isLoading = false))
        }
    }
    //endregion

    //region Private Functions
    private suspend fun getCoinModelList(): List<CoinModel> {

        val coins: List<CoinModel> = coinDao.getCoins()
                .map {
                    it.toCoinModel()
                }

        return coins
    }

    private suspend fun saveToLocal(coins: List<CoinDto>?) {
        coins?.let { coinList ->
            coinDao.clearCoins()
            coinDao.insertCoins(coinList.map { it.toCoinEntity() })
        }
    }
}