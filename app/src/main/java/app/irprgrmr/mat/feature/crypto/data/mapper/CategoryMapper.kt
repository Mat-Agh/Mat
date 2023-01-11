package app.irprgrmr.mat.feature.crypto.data.mapper

import app.irprgrmr.mat.feature.crypto.data.local.entitiy.CategoryEntity
import app.irprgrmr.mat.feature.crypto.data.remote.dto.CategoryDto
import app.irprgrmr.mat.feature.crypto.domain.model.CategoryModel

fun CategoryEntity.toCategoryModel(): CategoryModel = CategoryModel(
    id = mId,
    name = name
)

fun CategoryEntity.toCategoryDto(): CategoryDto = CategoryDto(
    id = mId,
    name = name
)

fun CategoryModel.toCategoryEntity(): CategoryEntity = CategoryEntity(
    mId = id,
    name = name
)

fun CategoryDto.toCategoryEntity(): CategoryEntity = CategoryEntity(
    mId = id,
    name = name
)

fun CategoryDto.toCategoryModel(): CategoryModel = CategoryModel(
    id = id,
    name = name
)