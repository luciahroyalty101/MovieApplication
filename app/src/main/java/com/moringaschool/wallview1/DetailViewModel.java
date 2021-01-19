package com.moringaschool.wallview1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.moringaschool.wallview1.model.MovieResults;

import java.util.List;

public class DetailViewModel extends AndroidViewModel {
    DetailRepository repository;

    public DetailViewModel(@NonNull Application application) {
        super(application);
        repository = new DetailRepository(application.getApplicationContext());
    }

    public void insertMovie(MovieResults movieResults) {
        repository.insertMovie(movieResults);
    }

    public void deleteMovie(MovieResults movieResults) {
        repository.deleteMovie(movieResults);
    }

    public LiveData<MovieResults> getSingleMovie(int movieId) {
        return repository.getSingleMovie(movieId);
    }

    public LiveData<List<MovieResults>> getAllMovies() {
        return repository.getAllMovies();
    }
}
