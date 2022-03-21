package com.example.mvp_rxjava_retrofit_project.presenter

import android.util.Log
import com.example.mvp_rxjava_retrofit_project.MainActivity
import com.example.mvp_rxjava_retrofit_project.contract.MovieInterface
import com.example.mvp_rxjava_retrofit_project.model.MovieModel

class MoviePresenter(view: MovieInterface.View): MovieInterface.Presenter {

    val view: MovieInterface.View = view
    val model: MovieInterface.Model = MovieModel()
    private val TAG = MainActivity::class.java.name

    override fun getData() {
       model.getPopularMovies(this)
    }

    override fun updateUi() {
        view.updateViewData()
    }

    override fun showMovies(): String? {
        return  model.getRequestResult()
    }
}