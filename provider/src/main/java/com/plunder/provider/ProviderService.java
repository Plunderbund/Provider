package com.plunder.provider;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.plunder.provider.ipc.ProviderInterface;
import com.plunder.provider.search.MovieSearchProvider;
import com.plunder.provider.search.MovieSearchRequest;
import com.plunder.provider.search.SearchResult;
import com.plunder.provider.search.TvSearchProvider;
import com.plunder.provider.search.TvSearchRequest;
import java.util.ArrayList;
import java.util.List;

public class ProviderService extends Service {
  private PlunderProvider provider;

  @Override public void onCreate() {
    super.onCreate();
    provider = PlunderProvider.get();
  }

  @Nullable @Override public final IBinder onBind(Intent intent) {
    return binder;
  }

  private List<SearchResult> performMovieSearch(MovieSearchRequest searchRequest) {
    if (searchRequest != null && provider != null) {
      MovieSearchProvider searchProvider = provider.getMovieSearchProvider();

      if (searchProvider != null) {
        List<SearchResult> results = searchProvider.performSearch(searchRequest);

        if (results != null) {
          return results;
        }
      }
    }

    return new ArrayList<>();
  }

  private List<SearchResult> performTvSearch(TvSearchRequest searchRequest) {
    if (searchRequest != null && provider != null) {
      TvSearchProvider searchProvider = provider.getTvSearchProvider();

      if (searchProvider != null) {
        List<SearchResult> results = searchProvider.performSearch(searchRequest);

        if (results != null) {
          return results;
        }
      }
    }

    return new ArrayList<>();
  }

  private String getName() {
    String name = null;

    if (provider != null) {
      name = provider.getName();
    }

    if (TextUtils.isEmpty(name)) {
      Context context = getApplicationContext();

      if (context != null) {
        name = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
      }
    }

    return name;
  }

  private final ProviderInterface.Stub binder = new ProviderInterface.Stub() {
    @Override public String getName() throws RemoteException {
      return ProviderService.this.getName();
    }

    @Override public List<SearchResult> searchTvShows(TvSearchRequest request)
        throws RemoteException {
      return performTvSearch(request);
    }

    @Override public List<SearchResult> searchMovies(MovieSearchRequest request)
        throws RemoteException {
      return performMovieSearch(request);
    }
  };
}
