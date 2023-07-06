package com.example.movies.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movies.R
import com.example.movies.composable.BookButton
import com.example.movies.composable.CloseButton
import com.example.movies.composable.MovieCategory
import com.example.movies.composable.MovieDuration
import com.example.movies.composable.Rate
import com.example.movies.composable.Title
import com.example.movies.composable.details.DetailsScreenBackground
import com.example.movies.screen.booking.navigateToBooking
import com.example.movies.ui.theme.CustomColors
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.ui.theme.Typography
import com.example.movies.viewmodel.details.DetailsUiState
import com.example.movies.viewmodel.details.DetailsViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    navController: NavController,
) {

    val state by viewModel.state.collectAsState()
    DetailsContent(
        state = state,
        onClickClose = { navController.popBackStack() },
        onClickBooking = { navController.navigateToBooking(state.id) }
    )
}

@Composable
fun DetailsContent(
    state: DetailsUiState,
    onClickClose: () -> Unit,
    onClickBooking: () -> Unit,
) {

    val customColors = CustomColors.current

    DetailsScreenBackground(imageUrl = state.imageUrl)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
    ) {

        Column(
            modifier = Modifier
                .weight(0.4f)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(87.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                CloseButton(onClickClose = onClickClose)

                Spacer(modifier = Modifier.weight(1f))

                MovieDuration(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.White.copy(alpha = 0.2f))
                        .padding(8.dp),
                    textColor = Color.White,
                    iconTint = Color.White
                )
            }

            IconButton(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(customColors.primary),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Play",
                    tint = Color.White
                )
            }

        }

        Card(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.5f)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp, vertical = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Rate(stringResource(id = R.string._6_8))

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.imdb),
                            style = Typography.bodyMedium,
                            color = Color.Gray
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = stringResource(R.string._63),
                            style = Typography.titleMedium,
                            color = customColors.textColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.rotten_tomatoes),
                            style = Typography.bodyMedium,
                            color = Color.Gray
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Rate(stringResource(R.string._4))

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.ign),
                            style = Typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }

                Title(
                    title = state.title,
                    modifier = Modifier.padding(horizontal = 64.dp),
                )

                MovieCategory(modifier = Modifier.padding(top = 16.dp))

                LazyRow(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(6) {
                        Image(
                            modifier = Modifier
                                .size(64.dp)
                                .padding(4.dp),
                            painter = painterResource(id = R.drawable.actor),
                            contentDescription = null,
                        )
                    }
                }

                Text(
                    modifier = Modifier
                        .padding(horizontal = 32.dp),
                    text = stringResource(R.string.description),
                    style = Typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                )

                BookButton(modifier = Modifier.padding(top = 16.dp),
                    onClickBooking = { onClickBooking() },
                     text =  stringResource(R.string.booking))
            }

        }
    }

}


@Preview
@Composable
fun DetailsScreenPreview() {
    MoviesTheme {
        DetailsContent(onClickClose = { }, state = DetailsUiState(), onClickBooking = { })
    }
}