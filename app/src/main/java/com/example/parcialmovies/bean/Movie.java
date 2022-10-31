package com.example.parcialmovies.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("year")
    public String year;
    @SerializedName("runtime")
    public String runtime;
    @SerializedName("director")
    public String director;
    @SerializedName("actors")
    public String actors;
    @SerializedName("plot")
    public String plot;
    @SerializedName("posterUrl")
    public String posterUrl;
    @SerializedName("genres")
    public List<String> genres;

    public Movie(int id, String title, String year, String runtime, String director, String actors, String plot, String posterUrl, List<String> genres) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.director = director;
        this.actors = actors;
        this.plot = plot;
        this.posterUrl = posterUrl;
        this.genres = genres;
    }

    public Movie() {
    }
}
