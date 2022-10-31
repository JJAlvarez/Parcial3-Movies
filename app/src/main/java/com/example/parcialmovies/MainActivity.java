package com.example.parcialmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.parcialmovies.adapter.BooksAdapter;
import com.example.parcialmovies.adapter.MoviesAdapter;
import com.example.parcialmovies.bean.Book;
import com.example.parcialmovies.bean.Movie;
import com.example.parcialmovies.presenter.BookPresenter;
import com.example.parcialmovies.presenter.IBookPresenter;
import com.example.parcialmovies.presenter.IMoviePresenter;
import com.example.parcialmovies.presenter.MoviePresenter;
import com.example.parcialmovies.view.IBookView;
import com.example.parcialmovies.view.IMovieView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMovieView, IBookView {

    private MoviesAdapter movieAdapter;
    private BooksAdapter bookAdapter;
    private IMoviePresenter moviePresenter;
    private IBookPresenter bookPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMovies = (RecyclerView) findViewById(R.id.movies_list);
        this.movieAdapter = new MoviesAdapter(new ArrayList<>());
        rvMovies.setAdapter(movieAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        this.bookAdapter = new BooksAdapter(new ArrayList<>());
        rvBooks.setAdapter(bookAdapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));

        this.moviePresenter = new MoviePresenter(this);
        this.moviePresenter.getMovies();

        this.bookPresenter = new BookPresenter(this);
        this.bookPresenter.getBooks();

        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }

    @Override
    public void onMoviesSuccess(List<Movie> movies) {
        this.movieAdapter.reloadData(movies);
    }

    @Override
    public void onMoviesFailure(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBookSuccess(List<Book> books) {
        this.bookAdapter.reloadData(books);
    }

    @Override
    public void onBookError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}