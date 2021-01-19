package com.moringaschool.wallview1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.moringaschool.wallview1.model.MovieResults;

import java.util.List;

public class PopularMoviesViewModel extends ViewModel {
    MainRepository repository;

    public PopularMoviesViewModel() {
        this.repository = new MainRepository();
    }

    public LiveData<List<MovieResults>> getPopularMovies() {
        return repository.getPopularMovies();
    }
}