package com.example.iwatch.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iwatch.Entities.Cinema
import com.example.iwatch.R
import com.example.iwatch.ViewHolders.MovieRoomViewHolder

class MovieRoomAdapter(val movieRoomList: ArrayList<Cinema>): RecyclerView.Adapter<MovieRoomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRoomViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.movie_room_item, parent, false)
        return MovieRoomViewHolder(v)
    }

    override fun getItemCount(): Int {
        return movieRoomList.size
    }

    override fun onBindViewHolder(holder: MovieRoomViewHolder, position: Int) {
        val movieRoom: Cinema = movieRoomList[position]

        holder.movieRoomName.text = movieRoom.name
        holder.movieRoomAddress.text = movieRoom.localisation
        holder.movieRoomPicture.setImageResource(R.mipmap.ic_drama)
    }
}