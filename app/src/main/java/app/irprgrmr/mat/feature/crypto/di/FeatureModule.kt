package app.irprgrmr.mat.feature.crypto.di

import android.app.Application
import androidx.room.Room
import app.irprgrmr.mat.common.constants.endPoint.CryptoApiEndPoint
import app.irprgrmr.mat.feature.crypto.data.local.database.CoinDatabase
import app.irprgrmr.mat.feature.crypto.data.remote.ServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FeatureModule {

    //Remote api
    @Provides
    @Singleton
    fun provideServiceApi(): ServiceApi = Retrofit.Builder()
        .baseUrl(CryptoApiEndPoint.END_POINT)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ServiceApi::class.java)

    //Local database
    @Provides
    @Singleton
    fun provideCryptoDatabase(app: Application): CoinDatabase = Room
        .databaseBuilder(
            app,
            CoinDatabase::class.java,
            CoinDatabase.NAME
        )
        .build()
}