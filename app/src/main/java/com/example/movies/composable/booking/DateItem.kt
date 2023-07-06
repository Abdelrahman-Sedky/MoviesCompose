package com.example.movies.composable.booking

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography

@Composable
fun DateItem(date: String) {

    val customColors = CustomColors.current

    Card(
        modifier = Modifier
            .width(59.dp)
            .height(36.dp),
        border = BorderStroke(2.dp, customColors.stroke),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Text(
                text = date,
                style = Typography.bodySmall,
            )
        }
    }
}

@Preview
@Composable
fun DateItemPreview() {
    MoviesTheme {
        DateItem(date = "12:00")
    }
}