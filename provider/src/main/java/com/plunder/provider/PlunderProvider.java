package com.plunder.provider;

import com.plunder.provider.search.MovieSearchProvider;
import com.plunder.provider.search.TvSearchProvider;

public class PlunderProvider {
  private static PlunderProvider provider;

  private MovieSearchProvider movieSearchProvider;
  private TvSearchProvider tvSearchProvider;
  private String name;

  static {
    provider = new PlunderProvider();
  }

  public static PlunderProvider get() {
    return provider;
  }

  public PlunderProvider() {
    name = BuildConfig.APPLICATION_ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MovieSearchProvider getMovieSearchProvider() {
    return movieSearchProvider;
  }

  public void setMovieSearchProvider(MovieSearchProvider movieSearchProvider) {
    this.movieSearchProvider = movieSearchProvider;
  }

  public TvSearchProvider getTvSearchProvider() {
    return tvSearchProvider;
  }

  public void setTvSearchProvider(TvSearchProvider tvSearchProvider) {
    this.tvSearchProvider = tvSearchProvider;
  }
}
