package com.example.parcialmovies.presenter;

import com.example.parcialmovies.bean.Movie;
import com.example.parcialmovies.model.IMovieModel;
import com.example.parcialmovies.model.MovieModel;
import com.example.parcialmovies.view.IMovieView;

import java.util.List;

public class MoviePresenter implements IMoviePresenter {

    private IMovieView view;
    private IMovieModel model;

    public MoviePresenter(IMovieView view) {
        this.view = view;
        this.model = new MovieModel(this);
    }

    @Override
    public void getMovies() {
        this.model.getMovies();
    }

    @Override
    public void onMoviesSuccess(List<Movie> movies) {
        this.view.onMoviesSuccess(movies);
    }

    @Override
    public void onMoviesFailure(String msg) {
        this.view.onMoviesFailure(msg);
    }
}
