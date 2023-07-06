package com.example.movies.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.R
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography

@Composable
fun BookButton(
    onClickBooking: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
) {
    val customColors = CustomColors.current

    TextButton(
        modifier = modifier,
        onClick = { onClickBooking() },
        colors = ButtonDefaults.buttonColors(
            containerColor = customColors.primary,
        ),
    ) {
        Icon(
            modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(id = R.drawable.ic_card),
            contentDescription = null,
            tint = Color.White
        )

        Text(
            text = text,
            style = Typography.bodyMedium
        )
    }

}


@Preview
@Composable
fun BookButtonPreview() {
    MoviesTheme {
        BookButton(onClickBooking = {}, "")
    }
}
