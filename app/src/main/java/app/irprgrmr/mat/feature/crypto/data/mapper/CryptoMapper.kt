package app.irprgrmr.mat.feature.crypto.data.mapper

import app.irprgrmr.mat.feature.crypto.data.local.entitiy.CryptoEntity
import app.irprgrmr.mat.feature.crypto.data.remote.dto.CryptoDto
import app.irprgrmr.mat.feature.crypto.domain.model.CryptoModel

fun CryptoEntity.toCryptoModel(): CryptoModel = CryptoModel(
    coins = coins.map { it.toCoinModel() },
    exchanges = exchanges.map { it.toExchangeModel() },
    icons = icons,
    nfts = nfts.map { it.toNFTModel() },
    categories = categories.map { it.toCategoryModel() }
)

fun CryptoEntity.toCryptoDto(): CryptoDto = CryptoDto(
    coins = coins.map { it.toCoinDto() },
    exchanges = exchanges.map { it.toExchangeDto() },
    icons = icons,
    nfts = nfts.map { it.toNFTDto() },
    categories = categories.map { it.toCategoryDto() }
)

fun CryptoModel.toCryptoEntity(): CryptoEntity = CryptoEntity(
    coins = coins?.map { it.toCoinEntity() } ?: listOf(),
    exchanges = exchanges?.map { it.toExchangeEntity() } ?: listOf(),
    icons = icons ?: listOf(),
    nfts = nfts?.map { it.toNFTEntity() } ?: listOf(),
    categories = categories?.map { it.toCategoryEntity() } ?: listOf()
)

fun CryptoDto.toCryptoEntity(): CryptoEntity = CryptoEntity(
    coins = coins?.map { it.toCoinEntity() } ?: listOf(),
    exchanges = exchanges?.map { it.toExchangeEntity() } ?: listOf(),
    icons = icons ?: listOf(),
    nfts = nfts?.map { it.toNFTEntity() } ?: listOf(),
    categories = categories?.map { it.toCategoryEntity() } ?: listOf()
)

fun CryptoDto.toCryptoModel(): CryptoModel = CryptoModel(
    coins = coins?.map { it.toCoinModel() },
    exchanges = exchanges?.map { it.toExchangeModel() },
    icons = icons,
    nfts = nfts?.map { it.toNFTModel() },
    categories = categories?.map { it.toCategoryModel() }
)