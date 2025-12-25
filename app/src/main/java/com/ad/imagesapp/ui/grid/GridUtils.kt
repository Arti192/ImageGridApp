package com.ad.imagesapp.ui.grid

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun rememberGridColumns(minCellSize: Dp = 120.dp): Int {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp.dp
    return max(2, (screenWidthDp / minCellSize).toInt())
}