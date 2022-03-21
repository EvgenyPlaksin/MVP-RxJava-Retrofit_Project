package com.example.mvp_rxjava_retrofit_project.api

import com.example.mvp_rxjava_retrofit_project.data.MovieResponse
import com.example.mvp_rxjava_retrofit_project.utils.Constants
import io.reactivex.Observable
import retrofit2.Call

import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("/v2/capital/moscow")
    fun getMovieList(): Observable<Response<MovieResponse>>

}