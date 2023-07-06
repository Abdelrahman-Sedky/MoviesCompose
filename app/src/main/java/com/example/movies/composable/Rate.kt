package com.example.movies.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.R
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography

@Composable
fun Rate(
    rate: String
) {
    val customColors = CustomColors.current

    Row {
        Text(
            text = rate,
            style = Typography.titleMedium,
            color = customColors.textColor
        )

        Text(
            text = stringResource(R.string._10),
            style = Typography.titleMedium,
            color = Color.Gray
        )
    }


}

@Preview
@Composable
fun RatePreview() {
    MoviesTheme {
        Rate("4")
    }
}