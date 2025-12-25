package com.ad.imagesapp.core.di

import android.content.Context
import com.ad.imagesapp.data.cache.DiskImageCache
import com.ad.imagesapp.data.cache.MemoryImageCache

class AppContainer(context: Context) {
    private val maxMemory = Runtime.getRuntime().maxMemory().toInt()
    private val cacheSize = maxMemory / 8

    val memoryImageCache: MemoryImageCache by lazy {
        MemoryImageCache(cacheSize)
    }

    val diskImageCache: DiskImageCache by lazy {
        DiskImageCache(context)
    }
}