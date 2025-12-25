package com.ad.imagesapp.data.cache

import android.graphics.Bitmap
import androidx.collection.LruCache

class MemoryImageCache(maxSizeInBytes: Int) {

    private val cache = object : LruCache<String, Bitmap>(maxSizeInBytes) {

        override fun sizeOf(key: String, value: Bitmap): Int {
            // Bitmap memory size in bytes
            return value.byteCount
        }
    }

    @Synchronized
    fun get(key: String): Bitmap? {
        return cache.get(key)
    }

    @Synchronized
    fun put(key: String, bitmap: Bitmap) {
        if (get(key) == null) {
            cache.put(key, bitmap)
        }
    }

    @Synchronized
    fun clear() {
        cache.evictAll()
    }
}