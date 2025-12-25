package com.ad.imagesapp.ui.grid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ad.imagesapp.domain.model.ImageItem
import com.ad.imagesapp.data.repository.ImageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ImageGridViewModel(private val repository: ImageRepository) : ViewModel(){


    private val _images = MutableStateFlow<List<ImageItem>>(emptyList())
    val images: StateFlow<List<ImageItem>> = _images

    init {
        loadImages()
    }

    private fun loadImages() {
        viewModelScope.launch {
            try {
                val result = repository.fetchImages()
                _images.value = result
            } catch (e: Exception) {
                // Optional: expose error state later
                _images.value = emptyList()
            }
        }
    }

    suspend fun loadImage(url: String) =
        repository.loadImage(url)
}