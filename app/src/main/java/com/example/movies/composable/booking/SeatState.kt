package com.example.movies.composable.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography

@Composable
fun SeatState(
    color: Color,
    title: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
                .clip(CircleShape)
                .background(color)

        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = title,
            style = Typography.bodySmall,
            color = Color.White
        )

    }
}


@Preview
@Composable
fun SeatStatePreview() {
    MoviesTheme {
        SeatState(Color(0xFFB5B5B5), "Available")
    }
}