package app.irprgrmr.mat.feature.crypto.data.mapper

import app.irprgrmr.mat.feature.crypto.data.local.entitiy.CoinEntity
import app.irprgrmr.mat.feature.crypto.data.remote.dto.CoinDto
import app.irprgrmr.mat.feature.crypto.domain.model.CoinModel

fun CoinEntity.toCoinModel(): CoinModel = CoinModel(
    id = mId,
    name = name,
    apiSymbol = apiSymbol,
    symbol = symbol,
    marketCapRank = marketCapRank,
    thumb = thumb,
    large = large
)

fun CoinEntity.toCoinDto(): CoinDto = CoinDto(
    id = mId,
    name = name,
    apiSymbol = apiSymbol,
    symbol = symbol,
    marketCapRank = marketCapRank,
    thumb = thumb,
    large = large
)

fun CoinModel.toCoinEntity(): CoinEntity = CoinEntity(
    mId = id,
    name = name,
    apiSymbol = apiSymbol,
    symbol = symbol,
    marketCapRank = marketCapRank,
    thumb = thumb,
    large = large
)

fun CoinDto.toCoinEntity(): CoinEntity = CoinEntity(
    mId = id,
    name = name,
    apiSymbol = apiSymbol,
    symbol = symbol,
    marketCapRank = marketCapRank,
    thumb = thumb,
    large = large
)

fun CoinDto.toCoinModel(): CoinModel = CoinModel(
    id = id,
    name = name,
    apiSymbol = apiSymbol,
    symbol = symbol,
    marketCapRank = marketCapRank,
    thumb = thumb,
    large = large
)
