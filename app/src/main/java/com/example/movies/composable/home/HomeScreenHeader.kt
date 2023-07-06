package com.example.movies.composable.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movies.R
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography
import com.example.movies.viewmodel.home.HomeUiState

@Composable
fun Header(
    state: HomeUiState,
    onClickNowShowing: () -> Unit,
    onClickComingSoon: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        NormalButton(
            state.nowShowing,
            stringResource(id = R.string.now_showing),
            onClick = { onClickNowShowing() })

        NormalButton(
            state.comingSoon,
            stringResource(id = R.string.coming_soon),
            onClick = { onClickComingSoon() }
        )
    }
}

@Composable
fun NormalButton(
    state: Boolean,
    text: String,
    onClick: () -> Unit,
) {
    val customColors = CustomColors.current

    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (state) customColors.primary else Color.Transparent,
        ),
        border = if (state) null else BorderStroke(1.dp, customColors.stroke),
    ) {
        Text(
            text = text,
            style = Typography.titleMedium
        )
    }
}

@Preview
@Composable
fun HeaderPreview() {
    MoviesTheme {
        Header(HomeUiState(), {}, {})
    }
}