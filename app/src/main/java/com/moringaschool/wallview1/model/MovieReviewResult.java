package com.moringaschool.wallview1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieReviewResult implements Parcelable {
    @SerializedName("id")
    String id;
    @SerializedName("author")
    String author;
    @SerializedName("content")
    String content;
    @SerializedName("url")
    String url;

    protected MovieReviewResult(Parcel in) {
        id = in.readString();
        author = in.readString();
        content = in.readString();
        url = in.readString();
    }

    public static final Creator<MovieReviewResult> CREATOR = new Creator<MovieReviewResult>() {
        @Override
        public com.nese.movieapp.model.reviews.MovieReviewResult createFromParcel(Parcel in) {
            return new com.nese.movieapp.model.reviews.MovieReviewResult(in);
        }

        @Override
        public com.nese.movieapp.model.reviews.MovieReviewResult[] newArray(int size) {
            return new com.nese.movieapp.model.reviews.MovieReviewResult[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(author);
        dest.writeString(content);
        dest.writeString(url);
    }
}
