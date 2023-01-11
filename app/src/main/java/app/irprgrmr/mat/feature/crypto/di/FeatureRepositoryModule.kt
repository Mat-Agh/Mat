package app.irprgrmr.mat.feature.crypto.di

import app.irprgrmr.mat.feature.crypto.data.repository.CryptoRepository
import app.irprgrmr.mat.feature.crypto.domain.repository.CoinRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FeatureRepositoryModule {

    //Repository
    @Binds
    @Singleton
    abstract fun bindCryptoRepository(cryptoRepository: CryptoRepository): CoinRepositoryInterface
}