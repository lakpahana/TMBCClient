package com.example.tmbcclient.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmbcclient.R
import com.example.tmbcclient.data.model.movie.Movie
import com.example.tmbcclient.data.model.tvshow.TvShow
import com.example.tmbcclient.data.model.tvshow.TvShowList
import com.example.tmbcclient.databinding.ListItemBinding
import com.example.tmbcclient.presentation.tvshows.MyViewHolder

class TvShowAdapter : RecyclerView.Adapter<MyViewHolder>() {
    val tvShowList = ArrayList<TvShow>()

    fun setList(movies:List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(movies)
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
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterURL = "https://image.tmdb.org/t/p/w500/"+tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }


}