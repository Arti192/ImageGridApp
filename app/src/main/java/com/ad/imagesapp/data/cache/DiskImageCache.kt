package com.ad.imagesapp.data.cache

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest

class DiskImageCache(context: Context) {

    private val cacheDir: File = File(context.cacheDir, "images").apply {
        if (!exists()) mkdirs()
    }

    fun get(key: String): Bitmap? {
        val file = File(cacheDir, key.toHashKey())
        if (!file.exists()) return null

        return BitmapFactory.decodeFile(file.absolutePath)
    }

    fun put(key: String, bitmap: Bitmap) {
        val file = File(cacheDir, key.toHashKey())
        if (file.exists()) return

        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
    }

    private fun String.toHashKey(): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(toByteArray())
        return hashBytes.joinToString("") { "%02x".format(it) }
    }
}