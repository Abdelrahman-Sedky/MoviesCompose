package com.example.movies.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier
) {
    val customColors = CustomColors.current

    Text(
        text = title,
        style = Typography.titleLarge,
        color = customColors.textColor,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview
@Composable
fun TitlePreview() {
    MoviesTheme {
        Title(title = "Title")
    }
}