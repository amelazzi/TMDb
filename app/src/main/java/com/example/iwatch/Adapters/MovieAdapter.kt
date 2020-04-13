package com.example.iwatch.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iwatch.Entities.Movie
import com.example.iwatch.R
import com.example.iwatch.ViewHolders.MovieViewHolder
import com.squareup.picasso.Picasso

class MovieAdapter (val movieList: ArrayList<Movie>): RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val film: Movie = movieList[position]

        holder.movietitle!!.text = film.title
        holder.movieresume!!.text = film.resume
        holder.datesortie!!.text= film.dateSortie
        System.out.println("cc")
        System.out.println(film.imgFilm.toString())

        if(film.imgFilm != null){
            val url = film.imgFilm
            Picasso.get().load(url).into(holder.moviepicture)

        }

    }
}