package com.app.movielistapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.movielistapp.R
import com.app.movielistapp.data.model.MoviesData
import com.app.movielistapp.shared.constant.CommonConstant
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.view_movie_detail_first_section.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetail : AppCompatActivity() {

    private val viewModel: MovieDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        receiveParameters()

        ll_movie_detail_back_icon.setOnClickListener { onBackPressed() }
        btn_add_to_watchlist.setOnClickListener { setWatchlistStatus() }
        btn_watch_trailer.setOnClickListener { showMediaPlayerDialog() }

    }

    private fun receiveParameters() {
        val movieDetail = intent.extras?.get(CommonConstant.MOVIE_DETAIL) as MoviesData
        viewModel.movieDetail = movieDetail
        viewModel.isWatchlist = movieDetail.isWatchlist
        bindData()
    }

    private fun bindData() {
        iv_movie_detail.setImageResource(viewModel.movieDetail.image)
        tv_movie_detail_title.text = viewModel.movieDetail.title
        tv_movie_detail_rating.text = viewModel.movieDetail.rating
        tv_movie_detail_description.text = viewModel.movieDetail.description
        tv_movie_detail_genre_value.text = viewModel.movieDetail.genre
        tv_movie_detail_released_date_value.text = resources.getString(R.string.movie_detail_released_date, viewModel.movieDetail.releaseYear, viewModel.movieDetail.releaseDay, viewModel.movieDetail.releaseMonth)
        setBtnAddToWatchlist()
    }

    private fun setWatchlistStatus() {
        viewModel.isWatchlist = !viewModel.isWatchlist
        setBtnAddToWatchlist()
        viewModel.setWatchlistStatus()
    }

    private fun setBtnAddToWatchlist() {
        btn_add_to_watchlist.text = if (viewModel.isWatchlist) getString(R.string.remove_from_watchlist) else getString(R.string.add_to_watchlist)
    }

    private fun showMediaPlayerDialog() {
        val intent = Intent(this, MediaPlayer::class.java)
        intent.putExtra(CommonConstant.MEDIA_PLAYER, viewModel.movieDetail.trailer)
        startActivity(intent)
    }
}