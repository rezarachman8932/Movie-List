package com.app.movielistapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesData(
    val id: Int,
    val title: String,
    val description: String,
    val rating: String,
    val duration: String,
    val genre: String,
    val releaseDay: String,
    val releaseMonth: String,
    val releaseYear: String,
    val trailer: String,
    val image: Int,
    var isWatchlist: Boolean = false
): Parcelable