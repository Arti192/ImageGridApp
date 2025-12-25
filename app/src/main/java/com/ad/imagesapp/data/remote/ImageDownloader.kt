package com.ad.imagesapp.data.remote

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.HttpURLConnection
import java.net.URL
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.withContext


object ImageDownloader {
    private val downloadSemaphore = Semaphore(4)
    suspend fun downloadBitmap(urlString: String): Bitmap? =
        withContext(Dispatchers.IO) {

            downloadSemaphore.acquire()

            var connection: HttpURLConnection? = null
            try {
                ensureActive()
                val url = URL(urlString)
                connection = (url.openConnection() as HttpURLConnection).apply {
                    connectTimeout = 10_000
                    readTimeout = 10_000
                    doInput = true
                    connect()
                }

                ensureActive()

                connection.inputStream.use { inputStream ->
                    BitmapFactory.decodeStream(inputStream)
                }

            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                null
            } finally {
                connection?.disconnect()
                downloadSemaphore.release()
            }
        }
}
