package com.app.movielistapp.view

import androidx.lifecycle.ViewModel
import com.app.movielistapp.data.model.MoviesData
import com.app.movielistapp.shared.usecase.MoviesUseCase
import org.koin.core.component.KoinComponent

class MovieDetailViewModel(private val moviesUseCase: MoviesUseCase): ViewModel(), KoinComponent {

    lateinit var movieDetail: MoviesData
    var isWatchlist: Boolean = false

    fun setWatchlistStatus() {
        moviesUseCase.setWatchlistStatus(movieDetail.id, isWatchlist)
    }

}