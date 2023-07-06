package com.example.movies.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.R
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography

@Composable
fun MovieCategory(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieType(type = stringResource(R.string.fantasy))
        MovieType(type = stringResource(R.string.adventure))
    }
}

@Composable
fun MovieType(type: String) {
    val customColors = CustomColors.current

    TextButton(
        modifier = Modifier.height(32.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        border = BorderStroke(1.dp, customColors.stroke),
    ) {
        Text(
            text = type,
            color = customColors.textColor,
            style = Typography.labelLarge
        )
    }
}

@Preview
@Composable
fun HomeScreenFooterPreview() {
    MoviesTheme {
        MovieCategory()
    }
}