package com.example.tmbcclient.presentation.tvshows

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmbcclient.R
import com.example.tmbcclient.databinding.ActivityTvShowBinding
import com.example.tmbcclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding
    @Inject
    lateinit var tvShowViewModelFactory: TvShowViewModelFactory

    private lateinit var tvShowViewModel:TvShowViewModel
        private lateinit var adapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel = ViewModelProvider(this,tvShowViewModelFactory).get(TvShowViewModel::class.java)

        initRecyclerView()
        displayTvShows()

    }

    private fun displayTvShows() {
        binding.progressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.gettvshows()
        response.observe(this, Observer {
            if (it !=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No TvShows Updated",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.recyclerView.adapter = adapter
    }

    //Update button

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.update,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
        R.id.action_update->{
            updateTvShows()
            true
        }else->super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        binding.progressBar.visibility = View.VISIBLE
        val response = tvShowViewModel.updateTvShows()
        response.observe(this, Observer {
            if (it !=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No TvShows Updated",Toast.LENGTH_LONG).show()
            }
        })
    }
}