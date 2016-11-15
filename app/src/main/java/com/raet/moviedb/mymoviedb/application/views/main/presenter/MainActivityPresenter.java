package com.raet.moviedb.mymoviedb.application.views.main.presenter;

import android.util.Log;

import com.raet.moviedb.mymoviedb.application.views.main.activities.MainActivity;
import com.raet.moviedb.mymoviedb.application.views.main.services.PopularMoviesServices;
import com.raet.moviedb.mymoviedb.model.entities.PopularMovie;

import java.util.List;

/**
 * Created by lourdes on 14/11/16.
 */

public class MainActivityPresenter implements IMainActivityPresenter {
    private MainActivity mActivity;
    private PopularMoviesServices popularMoviesServices;
    private static final String TAG = MainActivityPresenter.class.getSimpleName();

    @Override
    public void create(MainActivity mainActivity) {
        Log.d(TAG, "create presenter");
        mActivity = mainActivity;
        popularMoviesServices = new PopularMoviesServices(mainActivity, this);
        getMoviesData();
    }

    @Override
    public void getMoviesData() {
        popularMoviesServices.getPopularMovies();
    }

    @Override
    public void setPopularMovieInformation(List<PopularMovie> results) {
        mActivity.setPopularMovieInformation(results);
    }
}
