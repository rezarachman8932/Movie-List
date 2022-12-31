package com.app.movielistapp.shared.usecase

import com.app.movielistapp.data.repository.MoviesRepository

class MoviesUseCase(private val moviesRepository: MoviesRepository) {

    fun setWatchlistStatus(id: Int, status: Boolean) {
        moviesRepository.setWatchlistStatus(id, status)
    }

    fun getWatchlistStatus(id: Int): Boolean {
        return moviesRepository.getWatchlistStatus(id)
    }
}