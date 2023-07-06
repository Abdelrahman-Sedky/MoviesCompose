package com.example.movies.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.R
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography

@Composable
fun MovieDuration(
    modifier: Modifier = Modifier,
    textColor: Color = CustomColors.current.textColor,
    iconTint: Color = Color.Gray,
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(
                id = R.drawable.clock_circle
            ),
            contentDescription = null,
            tint = iconTint,
        )
        Text(
            text = stringResource(R.string._2h_30m),
            style = Typography.bodyMedium,
            color = textColor
        )
    }
}

@Preview
@Composable
fun MovieDetailsPreview() {
    MoviesTheme {
        MovieDuration()
    }
}
