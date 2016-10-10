package com.plunder.provider.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MovieSearchRequest implements Parcelable {
  private String name;
  private String imdbId;
  private Integer year;

  private MovieSearchRequest(@NonNull String name, @Nullable String imdbId,
      @Nullable Integer year) {
    this.name = name;
    this.imdbId = imdbId;
    this.year = year;
  }

  public String name() {
    return name;
  }

  public String imdbId() {
    return imdbId;
  }

  public Integer year() {
    return year;
  }

  public static class Builder {
    private String name;
    private String imdbId;
    private Integer year;

    public Builder name(String value) {
      name = value;
      return this;
    }

    public Builder imdbId(String value) {
      imdbId = value;
      return this;
    }

    public Builder year(Integer value) {
      year = value;
      return this;
    }

    public MovieSearchRequest build() {
      return new MovieSearchRequest(name, imdbId, year);
    }
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.name);
    dest.writeValue(this.imdbId);
    dest.writeValue(this.year);
  }

  protected MovieSearchRequest(Parcel in) {
    this.name = (String) in.readValue(getClass().getClassLoader());
    this.imdbId = (String) in.readValue(getClass().getClassLoader());
    this.year = (Integer) in.readValue(getClass().getClassLoader());
  }

  public static final Creator<MovieSearchRequest> CREATOR = new Creator<MovieSearchRequest>() {
    @Override public MovieSearchRequest createFromParcel(Parcel source) {
      return new MovieSearchRequest(source);
    }

    @Override public MovieSearchRequest[] newArray(int size) {
      return new MovieSearchRequest[size];
    }
  };
}
