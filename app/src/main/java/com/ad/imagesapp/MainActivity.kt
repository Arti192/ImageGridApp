package com.ad.imagesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ad.imagesapp.core.di.AppContainer
import com.ad.imagesapp.data.repository.ImageRepositoryImpl
import com.ad.imagesapp.ui.grid.ImageGridScreen
import com.ad.imagesapp.ui.grid.ImageGridViewModel
import com.ad.imagesapp.ui.grid.ImageGridViewModelFactory
import com.ad.imagesapp.ui.theme.ImagesAppTheme
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        // THIS is the key line
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        val appContainer = AppContainer(applicationContext)

        val repository = ImageRepositoryImpl(
            memoryCache = appContainer.memoryImageCache,
            diskCache = appContainer.diskImageCache
        )

        val viewModelFactory = ImageGridViewModelFactory(repository)
        setContent {
            val viewModel: ImageGridViewModel = viewModel(
                factory = viewModelFactory
            )

            ImageGridScreen(viewModel)

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImagesAppTheme {
        Greeting("Android")
    }
}