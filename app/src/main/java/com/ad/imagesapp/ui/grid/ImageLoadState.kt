package com.ad.imagesapp.ui.grid

import android.graphics.Bitmap

sealed class ImageLoadState {
    object Loading : ImageLoadState()
    data class Success(val bitmap: Bitmap) : ImageLoadState()
    object Error : ImageLoadState()
}