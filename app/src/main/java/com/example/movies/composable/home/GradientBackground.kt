package com.example.movies.composable.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme

@Composable
fun GradientBackground(
    background: String,
    modifier: Modifier = Modifier
) {
    val customColors = CustomColors.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .blur(200.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(background)
                .build(),
            modifier = Modifier
                .fillMaxSize()
                .weight(0.45f),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.55f)
                .background(customColors.background)
        )
    }
}

@Preview
@Composable
fun GradientBackgroundPreview() {
    MoviesTheme {
        GradientBackground(background = "")
    }
}