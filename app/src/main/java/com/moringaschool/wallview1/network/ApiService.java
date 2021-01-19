package com.moringaschool.wallview1.network;

import com.moringaschool.wallview1.model.MovieDetailResponse;
import com.moringaschool.wallview1.model.MovieResponse;
import com.moringaschool.wallview1.model.MovieReviewResponse;
import com.moringaschool.wallview1.model.MovieVideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies();

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies();

    @GET("movie/{id}")
    Call<MovieDetailResponse> getMovieDetail(@Path("id") int movieId);

    @GET("movie/{id}/videos")
    Call<MovieVideoResponse> getMovieVideos(@Path("id") int movieId);

    @GET("movie/{id}/reviews")
    Call<MovieReviewResponse> getMovieReviews(@Path("id") int movieId);
}
