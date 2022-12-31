package com.app.movielistapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.app.movielistapp.R
import com.app.movielistapp.data.model.MoviesData
import kotlinx.android.synthetic.main.view_movie_list.view.*

class MovieListAdapter(private val movieCallback: ((MoviesData) -> Unit)): RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private var items = arrayListOf<MoviesData>()

    private fun clearItem() = items.clear()

    fun setItem(movies: ArrayList<MoviesData>) {
        clearItem()
        items.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieListViewHolder {
        val layout = MovieListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_movie_list, parent, false))
        layout.setMovieListener(movieCallback)
        return layout
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.binding(items[position])
    }

    override fun getItemCount(): Int = items.size

    class MovieListViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private lateinit var movieCallback: (MoviesData) -> Unit

        fun setMovieListener(movieCallback: (MoviesData) -> Unit) {
            this.movieCallback = movieCallback
        }

        fun binding(movie: MoviesData) {
            with(itemView){
                iv_movie_list_item.setImageResource(movie.image)
                rv_movie_title.text = resources.getString(R.string.movie_title_list, movie.title, movie.releaseYear)
                rv_movie_description.text = resources.getString(R.string.rv_list_description, movie.duration, movie.genre)
                rv_on_my_watchlist.isVisible = movie.isWatchlist
                itemView.setOnClickListener {
                    movieCallback.invoke(movie)
                }
            }

        }

    }
}