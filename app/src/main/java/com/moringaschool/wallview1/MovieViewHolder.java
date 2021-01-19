package com.moringaschool.wallview1;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.wallview1.adapters.MovieAdapter;
import com.moringaschool.wallview1.model.MovieResults;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final MovieItemBinding binding;

    public MovieViewHolder(MovieItemBinding binding, MovieAdapter.OnMovieClickListener onMovieClickListener) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(v -> onMovieClickListener.onMovieClick(binding.getMovie()));
    }

    public void bind(MovieResults movieResults) {
        binding.setMovie(movieResults);
        binding.executePendingBindings();
    }

    public static MovieViewHolder create(LayoutInflater inflater, ViewGroup parent, MovieAdapter.OnMovieClickListener onMovieClickListener) {
        MovieItemBinding movieItemBinding = MovieItemBinding.inflate(inflater, parent, false);
        return new MovieViewHolder(movieItemBinding, onMovieClickListener);
    }
}

