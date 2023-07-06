package com.example.movies.composable.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movies.ui.theme.MoviesTheme

@Composable
fun DetailsScreenBackground(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier
                .weight(0.5f),
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl)
                .build(),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
        )

        Box(
            modifier = Modifier
                .weight(0.5f)
                .background(Color.Transparent)
        )
    }
}

@Preview
@Composable
fun DetailsScreenBackgroundPreview() {
    MoviesTheme {
        DetailsScreenBackground("")
    }
}