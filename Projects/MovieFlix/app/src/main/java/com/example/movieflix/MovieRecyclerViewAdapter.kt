package com.example.movieflix

import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MovieRecyclerViewAdapter (

    private val movies:Array<Movie>,
    private val mListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_movies, parent, false)
            return MovieViewHolder(view)
        }

        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            var mItem: Movie? = null

            val mMovieTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
            val mMovieSummary: TextView = mView.findViewById<View>(R.id.movie_summary) as TextView
            val mMovieImage: ImageView = mView.findViewById<View>(R.id.movie_image) as ImageView


            override fun toString(): String {
                return mMovieTitle.toString()
            }
        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
            val base_url = "https://image.tmdb.org/t/p/w400/"
            val movie = movies[position]

            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieSummary.text = movie.summary

            Glide.with(holder.mView)
            //https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY + "&language=en-US"
                .load(base_url + movie.imageUrl)
                .centerInside()
                .into(holder.mMovieImage)

            holder.mView.setOnClickListener{
                holder.mItem?.let { movie -> mListener?.onItemClick(movie) }
            }
        }

        override fun getItemCount(): Int {
            return movies.size
        }

}