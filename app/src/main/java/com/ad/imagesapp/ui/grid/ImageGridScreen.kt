package com.ad.imagesapp.ui.grid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.ad.imagesapp.domain.model.ImageItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageGridScreen(viewModel: ImageGridViewModel) {


    val images by viewModel.images.collectAsStateWithLifecycle()
    val columns = rememberGridColumns()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Media Coverages")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )

            )
        }
    ) { paddingValues ->

        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = images,
                key = { item -> item.id }
            ) { image ->
                ImageGridItem(image, viewModel)
            }
        }
    }

}



@Composable
fun ImageGridItem(item: ImageItem, viewModel: ImageGridViewModel) {

    val imageState by produceState<ImageLoadState>(
        initialValue = ImageLoadState.Loading,
        key1 = item.imageUrl
    ) {
        val bitmap = try {
            viewModel.loadImage(item.imageUrl)
        } catch (e: Exception) {
            null
        }

        value = if (bitmap != null) {
            ImageLoadState.Success(bitmap)
        } else {
            ImageLoadState.Error
        }
    }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        when (imageState) {

            is ImageLoadState.Loading -> {
                CircularProgressIndicator(
                    strokeWidth = 2.dp,
                    modifier = Modifier.size(24.dp)
                )
            }

            is ImageLoadState.Success -> {
                Image(
                    bitmap = (imageState as ImageLoadState.Success).bitmap.asImageBitmap(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            is ImageLoadState.Error -> {
                Box(modifier = Modifier.fillMaxSize().background(Color(0xFFE0E0E0)),
                    contentAlignment = Alignment.Center) {
                    Text(text = "Image unavailable", color = Color.DarkGray, fontSize = 12.sp)
                }
            }
        }
    }
}

