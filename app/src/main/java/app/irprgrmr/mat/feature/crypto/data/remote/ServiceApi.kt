package app.irprgrmr.mat.feature.crypto.data.remote

import app.irprgrmr.mat.feature.crypto.data.remote.dto.CryptoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    //region Services
    @GET("search")
    suspend fun getCryptoData(@Query("query") query: String?): Response<CryptoDto?>
    //endregion Services
}