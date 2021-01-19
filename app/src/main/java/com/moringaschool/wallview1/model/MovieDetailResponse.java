package com.moringaschool.wallview1.model;

import com.google.gson.annotations.SerializedName;

public class MovieDetailResponse {
    @SerializedName("id")
    int id;
    @SerializedName("backdrop_path")
    String backdropPath;
    @SerializedName("overview")
    String overview;
    @SerializedName("poster_path")
    String posterPath;
    @SerializedName("release_date")
    String relaseDate;
    @SerializedName("title")
    String title;
    @SerializedName("video")
    boolean video;
    @SerializedName("vote_average")
    double voteAverage;
    @SerializedName("vote_count")
    int voteCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getRelaseDate() {
        return relaseDate;
    }

    public void setRelaseDate(String relaseDate) {
        this.relaseDate = relaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
