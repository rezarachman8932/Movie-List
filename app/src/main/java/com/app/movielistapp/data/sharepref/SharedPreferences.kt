package com.app.movielistapp.data.sharepref

import android.content.Context
import com.app.movielistapp.shared.constant.SharedPreferenceConstant

class SharedPreferences(context: Context) {

    private val sessionPref = context.getSharedPreferences(SharedPreferenceConstant.PREF_SESSION, Context.MODE_PRIVATE)

    fun setWatchlistStatus(id: Int, status: Boolean) {
        when (id) {
            1 -> sessionPref.edit().putBoolean(SharedPreferenceConstant.MOVIE_TENET, status).apply()
            2 -> sessionPref.edit().putBoolean(SharedPreferenceConstant.MOVIE_SPIDER_MAN, status).apply()
            3 -> sessionPref.edit().putBoolean(SharedPreferenceConstant.MOVIE_KNIVES_OUT, status).apply()
            4 -> sessionPref.edit().putBoolean(SharedPreferenceConstant.MOVIE_GUARDIANS_OF_THE_GALAXY, status).apply()
            5 -> sessionPref.edit().putBoolean(SharedPreferenceConstant.MOVIE_AVENGERS, status).apply()
        }
    }

    fun getWatchlistStatus(id: Int): Boolean {
        return when (id) {
            1 -> sessionPref.getBoolean(SharedPreferenceConstant.MOVIE_TENET, false)
            2 -> sessionPref.getBoolean(SharedPreferenceConstant.MOVIE_SPIDER_MAN, false)
            3 -> sessionPref.getBoolean(SharedPreferenceConstant.MOVIE_KNIVES_OUT, false)
            4 -> sessionPref.getBoolean(SharedPreferenceConstant.MOVIE_GUARDIANS_OF_THE_GALAXY, false)
            5 -> sessionPref.getBoolean(SharedPreferenceConstant.MOVIE_AVENGERS, false)
            else -> false
        }
    }

}