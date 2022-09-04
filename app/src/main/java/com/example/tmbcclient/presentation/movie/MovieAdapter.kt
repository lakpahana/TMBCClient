package com.example.tmbcclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmbcclient.R
import com.example.tmbcclient.data.model.movie.Movie
import com.example.tmbcclient.data.model.movie.MovieList
import com.example.tmbcclient.databinding.ListItemBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class MovieAdapter(): RecyclerView.Adapter<MyViewHolder>()  {

        val movieList = ArrayList<Movie>()

        fun setList(movies:List<Movie>){
                movieList.clear()
                movieList.addAll(movies)
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding : ListItemBinding = DataBindingUtil.inflate(
                        layoutInflater,
                        R.layout.list_item,
                        parent,
                false
                )
                return MyViewHolder(binding)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                holder.bind(movieList[position])
        }

        override fun getItemCount(): Int {
                return movieList.size
        }
}


class MyViewHolder  (
val binding:ListItemBinding
        ): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
               binding.titleTextView.text = movie.title
                binding.descriptionTextView.text = movie.overview
                val posterUrl = "https://image.tmdb.org/t/p/w500"+movie.posterPath
                Glide.with(binding.imageView.context)
                        .load(posterUrl)
                        .into(binding.imageView)
        }

}