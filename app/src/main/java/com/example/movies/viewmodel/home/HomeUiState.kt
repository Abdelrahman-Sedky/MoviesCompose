package com.example.movies.viewmodel.home

import com.example.movies.data.Movie

data class HomeUiState(
    val nowShowing: Boolean = true,
    val comingSoon: Boolean = false,
    val page: Int = 1,
    val backgroundImage: String = "",
    val title: String = "",
    val movies: List<Movie> = emptyList()
)