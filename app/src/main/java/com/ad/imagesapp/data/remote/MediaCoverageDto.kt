package com.ad.imagesapp.data.remote

data class MediaCoverageDto(
    val id: String,
    val title: String,
    val thumbnail: ThumbnailDto?
)

data class ThumbnailDto(
    val domain: String,
    val basePath: String,
    val key: String
)
