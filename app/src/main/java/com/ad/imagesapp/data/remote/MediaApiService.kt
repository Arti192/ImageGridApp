package com.ad.imagesapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface MediaApiService {
    @GET("api/v2/content/misc/media-coverages")
    suspend fun fetchMediaCoverages(
        @Query("limit") limit: Int = 200
    ): List<MediaCoverageDto>
}