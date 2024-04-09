package com.nuhin13.giphy.features.giphylist.presentaion

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun GiphyShimmerItem(
    colors: List<Color> = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.DarkGray.copy(alpha = 0.5f)
    ),
    xShimmer: Float = 0f,
    yShimmer: Float = 0f,
    gradientWidth: Float = 2000f,
    animationSpec: InfiniteRepeatableSpec<Float> = infiniteRepeatable(
        animation = tween(durationMillis = 1300, delayMillis = 300, easing = FastOutSlowInEasing),
        repeatMode = RepeatMode.Restart
    )
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val animation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = gradientWidth,
        animationSpec = animationSpec, label = ""
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(xShimmer - animation.value, yShimmer - animation.value),
        end = Offset(xShimmer + animation.value, yShimmer + animation.value)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush)
    )
}

@Composable
fun itemShimmerBrush(showShimmer: Boolean = true, targetValue: Float = 1000f): Brush {
    return if (showShimmer) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.DarkGray.copy(alpha = 0.5f)
        )

        val transition = rememberInfiniteTransition(label = "")
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(800), repeatMode = RepeatMode.Reverse
            ), label = ""
        )
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}