package com.example.movies.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.R
import com.example.movies.ui.theme.MoviesTheme

@Composable
fun CloseButton(
    onClickClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .size(48.dp)
            .background(
                Color.White.copy(alpha = 0.2f)
            ),
        onClick = { onClickClose() },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.close_circle),
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun CloseButtonPreview() {
    MoviesTheme {
        CloseButton(onClickClose = {})
    }
}