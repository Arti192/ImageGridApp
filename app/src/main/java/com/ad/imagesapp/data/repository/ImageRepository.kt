package com.ad.imagesapp.data.repository

import android.graphics.Bitmap
import com.ad.imagesapp.domain.model.ImageItem

interface ImageRepository {

    suspend fun loadImage(url: String): Bitmap?

    suspend fun fetchImages(): List<ImageItem>
}