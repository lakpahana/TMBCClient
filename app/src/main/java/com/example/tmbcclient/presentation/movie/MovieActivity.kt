package com.example.tmbcclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmbcclient.R
import com.example.tmbcclient.databinding.ActivityMovieBinding
import com.example.tmbcclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel=ViewModelProvider(this,factory)
            .get(MovieViewModel::class.java)

        initrecyclerView()
        displayPopularMovies()



    }
    private fun initrecyclerView(){
        binding.movierecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movierecyclerView.adapter = adapter

    }

    private fun displayPopularMovies(){
        binding.movieprogressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
//            Log.i("MyTag",it.toString())
        if (it!=null){
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            binding.movieprogressBar.visibility = View.GONE
        }else{
            binding.movieprogressBar.visibility = View.GONE
            Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
        }
        })

    }
    //update button

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update ->{
                updatePopularMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updatePopularMovies(){
        binding.movieprogressBar.visibility = View.VISIBLE
        val responseLiveDate = movieViewModel.updateMovies()
        responseLiveDate.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieprogressBar.visibility = View.GONE
            }else{
                binding.movieprogressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
            }
        })
    }
}