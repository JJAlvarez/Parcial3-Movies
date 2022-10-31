package com.example.parcialmovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.parcialmovies.R;
import com.example.parcialmovies.bean.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> mMovies;
    private Context context;

    public MoviesAdapter(List<Movie> mMovies) {
        this.mMovies = mMovies;
    }

    public void reloadData(List<Movie> Movies) {
        this.mMovies = Movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(this.context);

        View contactView = inflater.inflate(R.layout.item_movie, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Movie movie = mMovies.get(position);

        // Set item views based on your views and data model
        holder.mMovieTitle.setText(movie.title);
        holder.mMovieYear.setText(movie.year);
        holder.mMovieRuntime.setText(movie.runtime);
        holder.mMovieGenres.setText(parseGenres(movie.genres));
        holder.mMovieDirector.setText(movie.director);
        holder.mMovieActors.setText(movie.actors);
        holder.mMoviePlot.setText(movie.plot);
        Glide.with(this.context).load(movie.posterUrl).into(holder.mMovieImage);
    }

    private String parseGenres(List<String> genres) {
        String result = "";
        for (String genre:
             genres) {
            result = result + genre + ", ";
        }

        return result;
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mMovieImage;
        private TextView mMovieTitle;
        private TextView mMovieYear;
        private TextView mMovieRuntime;
        private TextView mMovieGenres;
        private TextView mMovieDirector;
        private TextView mMovieActors;
        private TextView mMoviePlot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mMovieImage = itemView.findViewById(R.id.movie_image);
            mMovieTitle = itemView.findViewById(R.id.movie_title);
            mMovieYear = itemView.findViewById(R.id.movie_year);
            mMovieRuntime = itemView.findViewById(R.id.movie_runtime);
            mMovieGenres = itemView.findViewById(R.id.movie_genres);
            mMovieDirector = itemView.findViewById(R.id.movie_director);
            mMovieActors = itemView.findViewById(R.id.movie_actors);
            mMoviePlot = itemView.findViewById(R.id.movie_plot);

            // itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
