package com.ad.imagesapp.data.mapper

import com.ad.imagesapp.data.remote.MediaCoverageDto
import com.ad.imagesapp.domain.model.ImageItem

fun MediaCoverageDto.toImageItem(): ImageItem? {
    val thumb = thumbnail ?: return null

    val imageUrl =
        "${thumb.domain}/${thumb.basePath}/0/${thumb.key}"

    return ImageItem(
        id = id,
        imageUrl = imageUrl
    )
}