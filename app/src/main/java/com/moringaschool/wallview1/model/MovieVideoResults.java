package com.moringaschool.wallview1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieVideoResults implements Parcelable {
    @SerializedName("id")
    String id;
    @SerializedName("key")
    String key;
    @SerializedName("name")
    String name;
    @SerializedName("site")
    String site;

    protected MovieVideoResults(Parcel in) {
        id = in.readString();
        key = in.readString();
        name = in.readString();
        site = in.readString();
    }

    public static final Creator<MovieVideoResults> CREATOR = new Creator<MovieVideoResults>() {
        @Override
        public MovieVideoResults createFromParcel(Parcel in) {
            return new com.nese.movieapp.model.video.MovieVideoResults(in);
        }

        @Override
        public MovieVideoResults[] newArray(int size) {
            return new com.nese.movieapp.model.video.MovieVideoResults[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(key);
        dest.writeString(name);
        dest.writeString(site);
    }
}
