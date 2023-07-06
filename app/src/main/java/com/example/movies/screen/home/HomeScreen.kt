package com.example.movies.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movies.composable.BottomNav
import com.example.movies.composable.MovieCategory
import com.example.movies.composable.home.GradientBackground
import com.example.movies.composable.home.Header
import com.example.movies.composable.home.HomeScreenPager
import com.example.movies.composable.MovieDuration
import com.example.movies.composable.Title
import com.example.movies.screen.details.navigateToDetails
import com.example.movies.ui.theme.MoviesTheme
import com.example.movies.viewmodel.home.HomeUiState
import com.example.movies.viewmodel.home.HomeViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val state by viewModel.state.collectAsState()

    val pagerState = rememberPagerState(state.page)

    viewModel.updateBackgroundImage(state.movies[pagerState.currentPage].imageUrl)
    viewModel.updateTitle(state.movies[pagerState.currentPage].title)

    HomeScreenContent(pagerState, state,
        onClickCard = {
            navController.navigateToDetails(
                pagerState.currentPage
            )
        },
        onClickNowShowing = {
            viewModel.updateNowShowing()
        },
        onClickComingSoon = {
            viewModel.updateComingSoon()
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(
    pagerState: PagerState,
    state: HomeUiState,
    onClickCard: () -> Unit,
    onClickNowShowing: () -> Unit,
    onClickComingSoon: () -> Unit,
) {

    GradientBackground(background = state.backgroundImage)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Header(
            modifier = Modifier
                .padding(top = 16.dp),
            state = state,
            onClickNowShowing = onClickNowShowing,
            onClickComingSoon = onClickComingSoon
        )

        HomeScreenPager(
            modifier = Modifier.padding(top = 16.dp),
            pagerState = pagerState,
            images = state.movies,
            onClickCard = onClickCard
        )

        MovieDuration(
            modifier = Modifier.padding(top = 32.dp),
        )

        Title(
            title = state.title,
            Modifier.padding(horizontal = 50.dp, vertical = 16.dp),
        )

        MovieCategory()

        Spacer(modifier = Modifier.weight(1f))

        BottomNav()
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    MoviesTheme {
        HomeScreen(navController = rememberNavController())
    }
}





