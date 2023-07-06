package com.example.movies.composable.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movies.data.Movie
import com.example.movies.ui.theme.MoviesTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenPager(
    pagerState: PagerState,
    images: List<Movie>,
    onClickCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        modifier = modifier,
        pageCount = images.size,
        state = pagerState,
        contentPadding = PaddingValues(
            horizontal = 65.dp
        ),
    ) { page ->

        val pageOffset =
            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val imageSize by animateFloatAsState(
            targetValue = if (pageOffset != 0.0f) 0.85f else 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            ), label = ""
        )

        HomeScreenPagerItem(
            imageUrl = images[page].imageUrl,
            imageSize = imageSize,
            onClickCard = onClickCard
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenPagerItem(
    imageUrl: String,
    imageSize: Float,
    onClickCard: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(263.dp)
            .height(398.dp)
            .graphicsLayer {
                scaleX = imageSize
                scaleY = imageSize
            }
            .clip(RoundedCornerShape(32.dp)),
        onClick = onClickCard
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current).data(imageUrl)
                .build(),
            contentDescription = "image",
            contentScale = ContentScale.Crop,

            )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeScreenPagerPreview() {
    MoviesTheme {
        HomeScreenPager(
            pagerState = PagerState(),
            images = listOf(),
            onClickCard = {}
        )
    }
}