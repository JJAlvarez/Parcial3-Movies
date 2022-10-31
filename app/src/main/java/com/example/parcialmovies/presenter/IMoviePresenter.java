package com.example.parcialmovies.presenter;

import com.example.parcialmovies.bean.Movie;

import java.util.List;

public interface IMoviePresenter {

    void getMovies();
    void onMoviesSuccess(List<Movie> movies);
    void onMoviesFailure(String msg);
}
