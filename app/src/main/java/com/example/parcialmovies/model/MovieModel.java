package com.example.parcialmovies.model;

import com.example.parcialmovies.api.ApiClient;
import com.example.parcialmovies.api.MovieApi;
import com.example.parcialmovies.bean.MovieResponse;
import com.example.parcialmovies.presenter.IMoviePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieModel implements IMovieModel {

    private MovieApi api;
    private IMoviePresenter presenter;

    public MovieModel(IMoviePresenter presenter) {
        this.presenter = presenter;
        api = ApiClient.getMoviesInstance().create(MovieApi.class);
    }

    @Override
    public void getMovies() {
        Call<MovieResponse> movieCall = api.getMovies();
        movieCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                presenter.onMoviesSuccess(response.body().movies);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                presenter.onMoviesFailure("Error el obtener las peliculas");
            }
        });
    }
}
