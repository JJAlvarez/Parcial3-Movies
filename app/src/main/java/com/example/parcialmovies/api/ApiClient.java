package com.example.parcialmovies.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit movieRetrofit = null;
    private static Retrofit bookRetrofit = null;

    public static Retrofit getMoviesInstance() {
        if (movieRetrofit == null) {
            movieRetrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return movieRetrofit;
    }

    public static Retrofit getBooksInstance() {
        if (bookRetrofit == null) {
            bookRetrofit = new Retrofit.Builder()
                    .baseUrl("http://de-coding-test.s3.amazonaws.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return bookRetrofit;
    }
}
