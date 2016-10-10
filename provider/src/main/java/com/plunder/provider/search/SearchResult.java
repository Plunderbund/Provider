package com.plunder.provider.search;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class SearchResult implements Parcelable {
  private String name;
  private String uri;
  private Integer seeds;
  private Integer peers;
  private Long fileSize;

  private SearchResult(@NonNull String name, @NonNull String uri, @Nullable Integer seeds,
      @Nullable Integer peers, @Nullable Long fileSize) {
    this.name = name;
    this.uri = uri;
    this.seeds = seeds;
    this.peers = peers;
    this.fileSize = fileSize;
  }

  public Long fileSize() {
    return fileSize;
  }

  public String name() {
    return name;
  }

  public String uri() {
    return uri;
  }

  public Integer seeds() {
    return seeds;
  }

  public Integer peers() {
    return peers;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.name);
    dest.writeValue(this.uri);
    dest.writeValue(this.seeds);
    dest.writeValue(this.peers);
    dest.writeValue(this.fileSize);
  }

  protected SearchResult(Parcel in) {
    this.name = (String) in.readValue(getClass().getClassLoader());
    this.uri = (String) in.readValue(getClass().getClassLoader());
    this.seeds = (Integer) in.readValue(getClass().getClassLoader());
    this.peers = (Integer) in.readValue(getClass().getClassLoader());
    this.fileSize = (Long) in.readValue(getClass().getClassLoader());
  }

  @Override public String toString() {
    return "SearchResult{" +
        "name='" + name + '\'' +
        ", uri='" + uri + '\'' +
        ", seeds=" + seeds +
        ", peers=" + peers +
        ", fileSize=" + fileSize +
        '}';
  }

  public static final Creator<SearchResult> CREATOR = new Creator<SearchResult>() {
    @Override public SearchResult createFromParcel(Parcel source) {
      return new SearchResult(source);
    }

    @Override public SearchResult[] newArray(int size) {
      return new SearchResult[size];
    }
  };

  public static class Builder {
    private String name;
    private String uri;
    private Integer seeds;
    private Integer peers;
    private Long fileSize;

    public Builder name(String value) {
      name = value;
      return this;
    }

    public Builder uri(String value) {
      uri = value;
      return this;
    }

    public Builder seeds(Integer value) {
      seeds = value;
      return this;
    }

    public Builder peers(Integer value) {
      peers = value;
      return this;
    }

    public Builder fileSize(Long value) {
      fileSize = value;
      return this;
    }

    public SearchResult build() {
      return new SearchResult(name, uri, seeds, peers, fileSize);
    }
  }
}
