package com.example.loginandlegister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginandlegister.models.Movie
import com.example.loginandlegister.models.MovieResponse
import com.example.loginandlegister.services.MovieApiInterface
import com.example.loginandlegister.services.MovieApiService
import kotlinx.android.synthetic.main.activity_popular.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularActivity : AppCompatActivity() {

    private lateinit var  actionBar: ActionBar

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_popular)
            actionBar = supportActionBar!!
            actionBar.hide()
            movies_list.layoutManager = LinearLayoutManager(this)
            movies_list.setHasFixedSize(true)
            getMovieData { movies: List<Movie> ->
                movies_list.adapter = MovieAdapter(movies)

            }
        }

        private fun getMovieData(callback: (List<Movie>) -> Unit){
            val apiService = MovieApiService.getIntance().create(MovieApiInterface::class.java)
            apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                }

                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    return callback(response.body()!!.movies)
                }
            })
        }

    }
