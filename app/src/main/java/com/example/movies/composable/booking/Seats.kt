package com.example.movies.composable.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.R
import com.example.movies.ui.theme.MoviesTheme

@Composable
fun Seats() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Seat(modifier = Modifier.rotate(20f))
        Seat()
        Seat(modifier = Modifier.rotate(-20f))
    }
}

@Composable
fun Seat(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
        items(5) {
            Image(
                painter = painterResource(id = R.drawable.full_seat), contentDescription = null,
                modifier = modifier
                    .padding(vertical = 12.dp)
                    .background(Color.Black)
            )
        }
    }
}

@Preview
@Composable
fun SeatsPreview() {
    MoviesTheme {
        Seats()
    }
}