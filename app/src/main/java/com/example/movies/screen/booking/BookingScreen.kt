package com.example.movies.screen.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movies.R
import com.example.movies.composable.BookButton
import com.example.movies.composable.booking.CalenderItem
import com.example.movies.composable.CloseButton
import com.example.movies.composable.booking.DateItem
import com.example.movies.composable.booking.SeatState
import com.example.movies.composable.booking.Seats
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography
import com.example.movies.viewmodel.booking.BookingUiState
import com.example.movies.viewmodel.booking.BookingViewModel

@Composable
fun BookingScreen(
    viewModel: BookingViewModel = hiltViewModel(),
    navController: NavController,
) {

    val state by viewModel.state.collectAsState()

    BookingContent(
        state = state,
        onClickClose = { navController.popBackStack() }
    )

}

@Composable
fun BookingContent(
    state: BookingUiState,
    onClickClose: () -> Unit
) {

    val customColors = CustomColors.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .systemBarsPadding(),
    ) {
        CloseButton(onClickClose = { onClickClose() })

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(vertical = 16.dp),
            model = ImageRequest.Builder(LocalContext.current).data(state.imageUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Seats()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SeatState(Color.White, stringResource(R.string.available))
            SeatState(Color(0xFF3C3C3C), stringResource(R.string.taken))
            SeatState(customColors.primary, stringResource(R.string.selected))
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .weight(0.7f)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                LazyRow(
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(items = List(10) { Pair("21", "Sun") }) {
                        CalenderItem(first = it.first, second = it.second)
                    }
                }

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(items = List(10) { "10:00" }) {
                        DateItem(it)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                    ) {
                        Text(text = stringResource(R.string._100_00), style = Typography.titleLarge)
                        Text(
                            text = stringResource(R.string._4_tickets),
                            style = Typography.bodySmall,
                            color = Color.Gray
                        )
                    }

                    BookButton(
                        onClickBooking = { /*TODO*/ },
                        text = stringResource(R.string.buy_tickets)
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    MoviesTheme {
        BookingContent(onClickClose = { }, state = BookingUiState())
    }
}