package com.moringaschool.wallview1;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.moringaschool.wallview1.model.MovieResults;

import java.util.List;

public class DetailRepository {
    Context context;
    MovieDao movieDao;

    public DetailRepository(Context context) {
        this.context = context;
        MovieDatabase movieDatabase = MovieDatabase.getInstance(context);
        movieDao = movieDatabase.movieDao();
    }

    public void insertMovie(MovieResults movieResults) {
        MovieDatabase.databaseWriteExecutor.execute(() -> {
            movieDao.InsertMovie(movieResults);
        });
    }

    public void deleteMovie(MovieResults movieResults) {
        MovieDatabase.databaseWriteExecutor.execute(() -> {
            movieDao.DeleteMovie(movieResults);
        });
    }

    public LiveData<List<MovieResults>> getAllMovies() {
        return movieDao.getAllMovies();
    }

    public LiveData<MovieResults> getSingleMovie(int movieId) {
        return movieDao.getSingleMovie(movieId);
    }
}
