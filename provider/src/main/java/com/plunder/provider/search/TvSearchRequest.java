package com.plunder.provider.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class TvSearchRequest implements Parcelable {
  private String name;
  private Integer season;
  private Integer episode;
  private String query;

  private TvSearchRequest(@NonNull String name, @Nullable Integer season, @Nullable Integer episode,
      @Nullable String query) {
    this.name = name;
    this.season = season;
    this.episode = episode;
    this.query = query;
  }

  public String name() {
    return name;
  }

  public Integer season() {
    return season;
  }

  public Integer episode() {
    return episode;
  }

  public String query() {
    return query;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.name);
    dest.writeValue(this.season);
    dest.writeValue(this.episode);
    dest.writeValue(this.query);
  }

  protected TvSearchRequest(Parcel in) {
    this.name = (String) in.readValue(getClass().getClassLoader());
    this.season = (Integer) in.readValue(getClass().getClassLoader());
    this.episode = (Integer) in.readValue(getClass().getClassLoader());
    this.query = (String) in.readValue(getClass().getClassLoader());
  }

  @Override public String toString() {
    return "TvSearchRequest{" +
        "name='" + name + '\'' +
        ", season=" + season +
        ", episode=" + episode +
        ", query='" + query + '\'' +
        '}';
  }

  public static final Creator<TvSearchRequest> CREATOR = new Creator<TvSearchRequest>() {
    @Override public TvSearchRequest createFromParcel(Parcel source) {
      return new TvSearchRequest(source);
    }

    @Override public TvSearchRequest[] newArray(int size) {
      return new TvSearchRequest[size];
    }
  };

  public static class Builder {
    private String name;
    private Integer season;
    private Integer episode;
    private String query;

    public Builder name(String value) {
      name = value;
      return this;
    }

    public Builder season(Integer value) {
      season = value;
      return this;
    }

    public Builder episode(Integer value) {
      episode = value;
      return this;
    }

    public Builder query(String value) {
      query = value;
      return this;
    }

    public TvSearchRequest build() {
      return new TvSearchRequest(name, season, episode, query);
    }
  }
}
