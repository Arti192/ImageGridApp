package com.ad.imagesapp.ui.grid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ad.imagesapp.data.repository.ImageRepository

class ImageGridViewModelFactory(private val repository: ImageRepository)
    : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageGridViewModel::class.java)) {
            return ImageGridViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}