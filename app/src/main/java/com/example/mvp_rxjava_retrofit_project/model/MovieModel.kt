package com.example.mvp_rxjava_retrofit_project.model

import android.util.Log
import com.example.mvp_rxjava_retrofit_project.MainActivity
import com.example.mvp_rxjava_retrofit_project.api.MovieApi
import com.example.mvp_rxjava_retrofit_project.api.MovieService
import com.example.mvp_rxjava_retrofit_project.contract.MovieInterface
import com.example.mvp_rxjava_retrofit_project.data.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class MovieModel: MovieInterface.Model {

    private var final_data: String? = null
    private var apiclient: MovieService? = null
    private var compositeDisposable = CompositeDisposable()
    private val TAG = MainActivity::class.java.name
    override fun getRequestResult(): String? {
        Log.d(TAG, "final_data is $final_data")
        return final_data
    }

    init{
        apiclient = MovieApi.client.create(MovieService::class.java)
    }

    override fun getPopularMovies(presenter: MovieInterface.Presenter) {
       val observeble = apiclient?.getMovieList()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
        if (observeble != null) {
            compositeDisposable.add(
                observeble.subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))
        }
            }

    private fun onFailure(t: Throwable?) {
       Log.e(TAG, "error is $t")
    }

    private fun onResponse(response: Response<MovieResponse>?) {
        if(response?.isSuccessful!!){
            var result = response.body()?.total_pages
            Log.d("success", result.toString())
            final_data = result.toString()
        }
    }
}