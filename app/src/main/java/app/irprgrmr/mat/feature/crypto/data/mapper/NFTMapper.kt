package app.irprgrmr.mat.feature.crypto.data.mapper

import app.irprgrmr.mat.feature.crypto.data.local.entitiy.NFTEntity
import app.irprgrmr.mat.feature.crypto.data.remote.dto.NFTDto
import app.irprgrmr.mat.feature.crypto.domain.model.NFTModel

fun NFTEntity.toNFTModel(): NFTModel = NFTModel(
    id = mId,
    name = name
)

fun NFTEntity.toNFTDto(): NFTDto = NFTDto(
    id = mId,
    name = name
)

fun NFTModel.toNFTEntity(): NFTEntity = NFTEntity(
    mId = id,
    name = name
)

fun NFTDto.toNFTEntity(): NFTEntity = NFTEntity(
    mId = id,
    name = name
)

fun NFTDto.toNFTModel(): NFTModel = NFTModel(
    id = id,
    name = name
)