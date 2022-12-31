package com.app.movielistapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.movielistapp.R
import com.app.movielistapp.data.model.MoviesData
import com.app.movielistapp.shared.constant.CommonConstant
import com.app.movielistapp.shared.dialog.SortDialog
import com.app.movielistapp.shared.dialog.showCustomDialog
import com.app.movielistapp.view.adapter.MovieListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesHome : AppCompatActivity() {

    private val viewModel: MoviesHomeViewModel by viewModel()

    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieListAdapter = MovieListAdapter { navigateToMovieDetail(it) }
        rv_movie_list.adapter = movieListAdapter
        rv_movie_list.isNestedScrollingEnabled = false
        rv_movie_list.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        tv_text_button.setOnClickListener { sortData() }

    }

    override fun onResume() {
        super.onResume()
        setListMovies()
    }

    private fun navigateToMovieDetail(item: MoviesData) {
        val intent = Intent(this, MovieDetail::class.java)
        intent.putExtra(CommonConstant.MOVIE_DETAIL, item)
        startActivity(intent)
    }

    private fun sortData() {
        showCustomDialog(
            supportFragmentManager,
            CommonConstant.SORT_DIALOG,
            SortDialog(
                sortAction = viewModel.sortAction,
                topButtonCallback = {
                    viewModel.sortAction = it
                    setListMovies() },
                bottomButtonCallback = {
                    viewModel.sortAction = it
                    setListMovies() },
                cancelButtonCallback = {
                    viewModel.sortAction = null
                    setListMovies()
                }
            )
        )
    }

    private fun setListMovies() {
        viewModel.setListMovies()
        movieListAdapter.setItem(viewModel.listMovies)
    }
}