package com.app.movielistapp.view

import androidx.lifecycle.ViewModel
import com.app.movielistapp.R
import com.app.movielistapp.data.model.MoviesData
import com.app.movielistapp.shared.usecase.MoviesUseCase
import org.koin.core.component.KoinComponent

class MoviesHomeViewModel(private val moviesUseCase: MoviesUseCase): ViewModel(), KoinComponent {

    var listMovies = ArrayList<MoviesData>()
    var sortAction: Int? = null

    private fun getWatchlistStatus(id: Int): Boolean {
        return moviesUseCase.getWatchlistStatus(id)
    }

    fun setListMovies() {
        listMovies.clear()
        listMovies.add(MoviesData(1,
            "Tenet",
            "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.\n",
            "7.8",
            "2h 30 min",
            "Action, Sci-Fi",
            "3",
            "September",
            "2020",
            "LdOM0x0XDMo",
            R.drawable.tenet,
            getWatchlistStatus(1)))
        listMovies.add(MoviesData(2,
            "Spider-Man: Into the Spider-Verse",
            " Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.",
            "8.4",
            "1h 57min",
            "Action, Animation, Adventure",
            "14",
            "December",
            "2018",
            "tg52up16eq0",
            R.drawable.spider_man,
            getWatchlistStatus(2)))
        listMovies.add(MoviesData(3,
            "Knives Out",
            "A detective investigates the death of a patriarch of an eccentric, combative family.",
            "7.9",
            "2h 10min",
            "Comedy, Crime, Drama",
            "27",
            "November",
            "2019",
            "qGqiHJTsRkQ",
            R.drawable.knives_out,
            getWatchlistStatus(3)))
        listMovies.add(MoviesData(4,
            "Guardians of the Galaxy",
            " A group of intergalactic criminals must pull together to stop a fanatical warrior with",
            "8.0",
            "2h 1min",
            "Action, Adventure, Comedy",
            "1",
            "August",
            "2014",
            "d96cjJhvlMA",
            R.drawable.guardians_of_the_galaxy,
            getWatchlistStatus(4)))
        listMovies.add(MoviesData(5,
            "Avengers: Age of Ultron",
            "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
            "7.3",
            "2h 21min",
            "Action, Adventure, Sci-Fi",
            "1",
            "May",
            "2015",
            "tmeOjFno6Do",
            R.drawable.avengers,
            getWatchlistStatus(5)))
        when (sortAction) {
            0 -> listMovies.sortBy { it.title }
            1 -> listMovies.sortBy { it.releaseYear }
            else -> return
        }
    }

}