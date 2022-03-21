package com.example.mvp_rxjava_retrofit_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mvp_rxjava_retrofit_project.contract.MovieInterface
import com.example.mvp_rxjava_retrofit_project.databinding.ActivityMainBinding
import com.example.mvp_rxjava_retrofit_project.presenter.MoviePresenter

//https://api.themoviedb.org/3/movie/popular?api_key=3420e54c7711fa5ea40952186bc8dd45
class MainActivity : AppCompatActivity(), MovieInterface.View{

    private lateinit var binding: ActivityMainBinding
    private var presenter = MoviePresenter(this)
    private val TAG = MainActivity::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.getData()
        presenter.updateUi()

    }

    override fun updateViewData() {
        binding.button.setOnClickListener {
            binding.testtv.text = presenter.showMovies().toString()
        }
    }
}