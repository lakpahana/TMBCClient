package com.example.tmbcclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.tmbcclient.R
import com.example.tmbcclient.databinding.ActivityMovieBinding
import com.example.tmbcclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)
        movieViewModel=ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("MyTag",it.toString())
        })

    }
}