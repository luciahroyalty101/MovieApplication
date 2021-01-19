package com.moringaschool.wallview1.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.moringaschool.wallview1.model.MovieResults;
import com.nese.movieapp.model.movie.MovieResults;

public class MovieAdapter extends ListAdapter<MovieResults, MovieViewHolder> {
    OnMovieClickListener onMovieClickListener;

    public MovieAdapter(@NonNull DiffUtil.ItemCallback<MovieResults> diffCallback, OnMovieClickListener onMovieClickListener) {
        super(diffCallback);
        this.onMovieClickListener = onMovieClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MovieViewHolder.create(LayoutInflater.from(parent.getContext()), parent, onMovieClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class MovieDiff extends DiffUtil.ItemCallback<MovieResults> {
        @Override
        public boolean areItemsTheSame(@NonNull MovieResults oldItem, @NonNull MovieResults newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MovieResults oldItem, @NonNull MovieResults newItem) {
            return oldItem.getMovieId() == newItem.getMovieId();
        }
    }

    public interface OnMovieClickListener {
        void onMovieClick(MovieResults movieResults);
    }
}
