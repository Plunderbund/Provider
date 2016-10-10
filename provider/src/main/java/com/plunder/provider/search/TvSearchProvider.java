package com.plunder.provider.search;

import android.support.annotation.NonNull;
import java.util.List;

public interface TvSearchProvider {
  List<SearchResult> performSearch(@NonNull TvSearchRequest request);
}
