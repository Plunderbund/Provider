package com.plunder.provider.ipc;

import com.plunder.provider.search.MovieSearchRequest;
import com.plunder.provider.search.TvSearchRequest;
import com.plunder.provider.search.SearchResult;

interface ProviderInterface {
  String getName();

  List<SearchResult> searchTvShows(in TvSearchRequest request);

  List<SearchResult> searchMovies(in MovieSearchRequest request);
}
