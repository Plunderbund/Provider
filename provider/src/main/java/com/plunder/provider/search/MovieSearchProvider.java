package com.plunder.provider.search;

import android.support.annotation.NonNull;
import java.util.List;

public interface MovieSearchProvider {
  List<SearchResult> performSearch(@NonNull MovieSearchRequest request);
}
