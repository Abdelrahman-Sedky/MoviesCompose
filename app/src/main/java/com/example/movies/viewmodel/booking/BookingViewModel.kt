package com.example.movies.viewmodel.booking

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.movies.data.MoviesData
import com.example.movies.screen.details.DetailsArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val moviesData: MoviesData,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(BookingUiState())
    val state = _state.asStateFlow()

    private val args = DetailsArgs(savedStateHandle = savedStateHandle)


    init {
        onInit()
    }

    private fun onInit() {
        _state.update {
            it.copy(
                id = args.id as Int,
                imageUrl = moviesData.movies[args.id].imageUrl,
                title = moviesData.movies[args.id].title
            )
        }
    }


}