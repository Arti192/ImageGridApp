package com.ad.imagesapp.data.repository

import android.graphics.Bitmap
import android.os.Build
import androidx.annotation.RequiresApi
import com.ad.imagesapp.data.cache.DiskImageCache
import com.ad.imagesapp.data.cache.MemoryImageCache
import com.ad.imagesapp.data.mapper.toImageItem
import com.ad.imagesapp.data.remote.ImageDownloader.downloadBitmap
import com.ad.imagesapp.data.remote.RetrofitClient
import com.ad.imagesapp.domain.model.ImageItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(
    private val memoryCache: MemoryImageCache,
    private val diskCache: DiskImageCache) : ImageRepository {


    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun loadImage(url: String): Bitmap? =
        withContext(Dispatchers.IO) {
            //  Memory cache
            memoryCache.get(url)?.let {
                return@withContext it
            }

            //  Disk cache (next step)

            diskCache.get(url)?.let { bitmap ->
                memoryCache.put(url, bitmap)
                return@withContext bitmap
            }

            //  Network (next step)
            val bitmap = downloadBitmap(url) ?: return@withContext null

            //  Save to caches
            memoryCache.put(url, bitmap)
            diskCache.put(url, bitmap)

             bitmap
    }

    override suspend fun fetchImages(): List<ImageItem> =
        withContext(Dispatchers.IO) {
            RetrofitClient.api
                .fetchMediaCoverages()
                .mapNotNull { it.toImageItem() }
        }
}