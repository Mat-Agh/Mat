package app.irprgrmr.mat.feature.crypto.data.mapper

import app.irprgrmr.mat.feature.crypto.data.local.entitiy.ExchangeEntity
import app.irprgrmr.mat.feature.crypto.data.remote.dto.ExchangeDto
import app.irprgrmr.mat.feature.crypto.domain.model.ExchangeModel

fun ExchangeEntity.toExchangeModel(): ExchangeModel = ExchangeModel(
    id = mId,
    name = name,
    marketType = marketType,
    thumb = thumb,
    large = large
)

fun ExchangeEntity.toExchangeDto(): ExchangeDto = ExchangeDto(
    id = mId,
    name = name,
    marketType = marketType,
    thumb = thumb,
    large = large
)

fun ExchangeModel.toExchangeEntity(): ExchangeEntity = ExchangeEntity(
    mId = id,
    name = name,
    marketType = marketType,
    thumb = thumb,
    large = large
)

fun ExchangeDto.toExchangeEntity(): ExchangeEntity = ExchangeEntity(
    mId = id,
    name = name,
    marketType = marketType,
    thumb = thumb,
    large = large
)

fun ExchangeDto.toExchangeModel(): ExchangeModel = ExchangeModel(
    id = id,
    name = name,
    marketType = marketType,
    thumb = thumb,
    large = large
)