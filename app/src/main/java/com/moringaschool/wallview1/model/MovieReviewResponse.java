package com.moringaschool.wallview1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieReviewResponse {
    @SerializedName("id")
    int id;
    @SerializedName("page")
    int page;
    @SerializedName("total_pages")
    int totalPages;
    @SerializedName("total_results")
    int totalResults;
    @SerializedName("results")
    List<MovieReviewResult> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<MovieReviewResult> getResults() {
        return results;
    }

    public void setResults(List<MovieReviewResult> results) {
        this.results = results;
    }
}
