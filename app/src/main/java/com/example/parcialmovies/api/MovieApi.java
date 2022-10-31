package com.example.parcialmovies.api;

import com.example.parcialmovies.bean.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("/erik-sytnyk/movies-list/master/db.json")
    Call<MovieResponse> getMovies();
}
