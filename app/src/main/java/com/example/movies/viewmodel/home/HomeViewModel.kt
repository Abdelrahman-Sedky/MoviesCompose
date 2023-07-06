package com.example.movies.viewmodel.home

import androidx.lifecycle.ViewModel
import com.example.movies.data.MoviesData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesData: MoviesData
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getMoviesData()
    }

    private fun getMoviesData() {
        _state.update {
            it.copy(
                movies = moviesData.movies
            )
        }
    }

    fun updateNowShowing() {
        _state.update {
            it.copy(
                nowShowing = true,
                comingSoon = false
            )
        }
    }

    fun updateComingSoon() {
        _state.update {
            it.copy(
                nowShowing = false,
                comingSoon = true
            )
        }
    }

    fun updateBackgroundImage(imageUrl: String) {
        _state.update {
            it.copy(
                backgroundImage = imageUrl
            )
        }
    }

    fun updateTitle(title: String) {
        _state.update {
            it.copy(
                title = title
            )
        }
    }

}