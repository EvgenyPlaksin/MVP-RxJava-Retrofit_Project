package com.example.mvp_rxjava_retrofit_project.contract

import com.example.mvp_rxjava_retrofit_project.data.MovieResponse

interface MovieInterface {

    interface Model{
       fun getRequestResult(): String?
        fun getPopularMovies(presenter: Presenter)
    }

    interface View{
        fun updateViewData()
    }

    interface Presenter{
       fun getData()
       fun updateUi()
       fun showMovies(): String?
    }

}