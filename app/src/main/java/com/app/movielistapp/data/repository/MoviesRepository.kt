package com.app.movielistapp.data.repository

import com.app.movielistapp.data.sharepref.SharedPreferences

class MoviesRepository(private val sharedPreferences: SharedPreferences) {

    fun setWatchlistStatus(id: Int, status: Boolean) {
        sharedPreferences.setWatchlistStatus(id, status)
    }

    fun getWatchlistStatus(id: Int): Boolean {
        return sharedPreferences.getWatchlistStatus(id)
    }
}