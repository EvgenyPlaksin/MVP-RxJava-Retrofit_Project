package com.example.mvp_rxjava_retrofit_project.data

data class MovieResponse(
    var page: Int,
    var results: List<Result>,
    var total_pages: Int,
    var total_results: Int
)