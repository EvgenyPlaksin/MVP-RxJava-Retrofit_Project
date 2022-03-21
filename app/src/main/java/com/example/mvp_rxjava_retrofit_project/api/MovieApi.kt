package com.example.mvp_rxjava_retrofit_project.api

import com.example.mvp_rxjava_retrofit_project.utils.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {

    companion object {

        private var retrofit: Retrofit? = null

        val client: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(Constants.BASE_URL)
                        .build()
                }
                return retrofit!!
            }
    }
}