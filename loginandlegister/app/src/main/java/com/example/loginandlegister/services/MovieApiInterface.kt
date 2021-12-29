package com.example.loginandlegister.services

import com.example.loginandlegister.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=e9abfac4de2b70c514d1daa5a88ebc2f&language=ko-KR&region=KR")
    fun getMovieList(): Call<MovieResponse>
}