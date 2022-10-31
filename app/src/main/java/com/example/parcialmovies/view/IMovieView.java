package com.example.parcialmovies.view;

import com.example.parcialmovies.bean.Movie;

import java.util.List;

public interface IMovieView {

    void onMoviesSuccess(List<Movie> movies);
    void onMoviesFailure(String msg);
}
